package com.example.shoppinglist.data

import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.shoppinglist.domain.ShopItem
import com.example.shoppinglist.domain.ShopListRepository
import org.json.JSONArray
import org.json.JSONObject

object ShopListRepositoryImpl : ShopListRepository {

    private const val PREFS_NAME = "shop_list_prefs"
    private const val KEY_SHOP_LIST = "shop_list"

    private lateinit var prefs: SharedPreferences

    private val shopListLD = MutableLiveData<List<ShopItem>>()
    private val shopList = sortedSetOf<ShopItem>(Comparator<ShopItem> { o1, o2 -> o1.id.compareTo(o2.id) })
    private var autoIncrementId = 0

    fun init(context: Context) {
        if (::prefs.isInitialized) return
        prefs = context.applicationContext.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        loadFromPrefs()
        shopListLD.value = shopList.toList()
    }

    override fun addShopListItem(shopItem: ShopItem) {
        if (shopItem.id == ShopItem.UNDEFINED_ID) {
            shopItem.id = autoIncrementId++
        }
        shopList.add(shopItem)
        updateList()
    }

    override fun deleteShopItem(shopItem: ShopItem) {
        shopList.remove(shopItem)
        updateList()
    }

    override fun editShopItem(shopItem: ShopItem) {
        val oldElement = getShopItem(shopItem.id)
        shopList.remove(oldElement)
        addShopListItem(shopItem)
    }

    override fun getShopItem(shopItemId: Int): ShopItem {
        return shopList.find { it.id == shopItemId }
            ?: throw RuntimeException("Element with id $shopItemId not found")
    }

    override fun getShopList(): LiveData<List<ShopItem>> {
        return shopListLD
    }

    private fun updateList() {
        shopListLD.value = shopList.toList()
        saveToPrefs()
    }

    private fun saveToPrefs() {
        val array = JSONArray()
        shopList.forEach { item ->
            val obj = JSONObject()
            obj.put("id", item.id)
            obj.put("name", item.name)
            obj.put("count", item.count)
            obj.put("enabled", item.enabled)
            array.put(obj)
        }
        prefs.edit().putString(KEY_SHOP_LIST, array.toString()).apply()
    }

    private fun loadFromPrefs() {
        val json = prefs.getString(KEY_SHOP_LIST, null) ?: return
        val array = JSONArray(json)
        for (i in 0 until array.length()) {
            val obj = array.getJSONObject(i)
            val item = ShopItem(
                name = obj.getString("name"),
                count = obj.getInt("count"),
                enabled = obj.getBoolean("enabled"),
                id = obj.getInt("id")
            )
            shopList.add(item)
        }
        autoIncrementId = (shopList.maxOfOrNull { it.id } ?: -1) + 1
    }
}
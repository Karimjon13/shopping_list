package com.example.shoppinglist.presentation

import androidx.lifecycle.ViewModel
import com.example.shoppinglist.data.ShopListRepositoryImpl
import com.example.shoppinglist.domain.DeleteShopListItemUseCase
import com.example.shoppinglist.domain.EditShopListItemUseCase
import com.example.shoppinglist.domain.GetShopListUseCase
import com.example.shoppinglist.domain.ShopItem

class MainViewModel: ViewModel() {
    private val repository = ShopListRepositoryImpl
    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopListItemUseCase = DeleteShopListItemUseCase (repository)
    private val editShopListItemUseCase = EditShopListItemUseCase(repository)
    val shopList = getShopListUseCase.getShopList()

    fun deleteShopListItem(shopItem: ShopItem){
        deleteShopListItemUseCase.deleteShopItem(shopItem)
    }
    fun changeEnableState(shopItem: ShopItem){
        val newItem = shopItem.copy(enabled = !shopItem.enabled)
        editShopListItemUseCase.editShopItemUseCase(newItem)
    }
}
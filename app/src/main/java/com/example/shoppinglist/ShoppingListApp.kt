package com.example.shoppinglist

import android.app.Application
import com.example.shoppinglist.data.ShopListRepositoryImpl

class ShoppingListApp : Application() {
    override fun onCreate() {
        super.onCreate()
        ShopListRepositoryImpl.init(this)
    }
}
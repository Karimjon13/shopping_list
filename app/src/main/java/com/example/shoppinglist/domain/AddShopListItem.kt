package com.example.shoppinglist.domain

class AddShopListItem(private val shopListRepository: ShopListRepository) {
    fun addShopListItem(shopItem:ShopItem){
        shopListRepository.addShopListItem(shopItem)
    }
}
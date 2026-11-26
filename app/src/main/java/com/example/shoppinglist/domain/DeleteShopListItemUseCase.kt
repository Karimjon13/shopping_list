package com.example.shoppinglist.domain

class DeleteShopListItemUseCase(private val shopListRepository: ShopListRepository) {
    fun deleteShopItem(shopItem:ShopItem){
        shopListRepository.deleteShopItem(shopItem)
    }
}
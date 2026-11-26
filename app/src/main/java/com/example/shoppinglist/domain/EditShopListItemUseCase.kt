package com.example.shoppinglist.domain

class EditShopListItemUseCase(private val shopListRepository: ShopListRepository) {
    fun editShopItemUseCase(shopItem: ShopItem){
        shopListRepository.editShopItem(shopItem)
    }
}
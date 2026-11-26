package com.example.shoppinglist.presentation

import androidx.recyclerview.widget.DiffUtil
import com.example.shoppinglist.domain.ShopItem

class ShopItemDiffCallback: DiffUtil.ItemCallback<ShopItem>() {
    override fun areItemsTheSame(
        p0: ShopItem,
        p1: ShopItem
    ): Boolean {
       return p0.id == p1.id
    }

    override fun areContentsTheSame(
        p0: ShopItem,
        p1: ShopItem
    ): Boolean {
        return p0 == p1
    }
}
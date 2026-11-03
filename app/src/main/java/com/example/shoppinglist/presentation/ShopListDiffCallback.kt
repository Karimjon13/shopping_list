package com.example.shoppinglist.presentation

import androidx.recyclerview.widget.DiffUtil
import com.example.shoppinglist.domain.ShopItem

class ShopListDiffCallback(
    private val oldList : List<ShopItem>,
    private val newList : List<ShopItem>
): DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(p0: Int, p1: Int): Boolean {
        val oldItem =oldList[p0]
        val newItem = newList[p1]
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(p0: Int, p1: Int): Boolean {
        val oldItem = oldList[p0]
        val newItem = newList[p1]
        return oldItem == newItem
    }
}
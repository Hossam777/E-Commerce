package com.project.ecommerce.shopfragment.domain

import com.project.ecommerce.shopfragment.data.ListItem
import com.project.ecommerce.shopfragment.data.ShopListRepository

class GetShopLists(private val shopListRepository: ShopListRepository ) {
    suspend fun getShopLists(): MutableList<MutableList<ListItem>> {
        return shopListRepository.fetchShopLists()
    }
}
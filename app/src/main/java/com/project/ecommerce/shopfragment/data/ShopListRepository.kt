package com.project.ecommerce.shopfragment.data

import kotlinx.coroutines.delay

class ShopListRepository {
    suspend fun fetchShopLists(): MutableList<MutableList<ListItem>> {
        delay(1000)
        return shopLists
    }
}
package com.project.ecommerce.shopfragmentlayer2.data

import kotlinx.coroutines.delay

class ShopCategoriesRepository {
    suspend fun fetchCategories (): MutableList<Category> {
        delay(1000)
        return categories
    }
}
package com.project.ecommerce.shopfragmentlayer2.domain

import com.project.ecommerce.shopfragmentlayer2.data.Category
import com.project.ecommerce.shopfragmentlayer2.data.ShopCategoriesRepository

class GetCategoriesList(private val shopCategoriesRepository: ShopCategoriesRepository) {
    suspend fun getCategories (): MutableList<Category> {
        return shopCategoriesRepository.fetchCategories()
    }
}
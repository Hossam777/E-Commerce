package com.project.ecommerce.shopfragmentlayer3.data

data class Product(
        val id: String,
        val name: String,
        val bannerLink: String,
        val price: Double,
        val discount: Double?,
        val brand: String,
        val rating: Int,
)

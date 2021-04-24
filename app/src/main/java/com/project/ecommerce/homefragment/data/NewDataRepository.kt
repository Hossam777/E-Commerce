package com.project.ecommerce.homefragment.data

import kotlinx.coroutines.delay

class NewDataRepository {
    suspend fun fetchNewData (): MutableList<NewProduct> {
        delay(1000)
        return newProductsData
    }
}
package com.project.ecommerce.homefragment.data

import kotlinx.coroutines.delay

class SaleDataRepository {
    suspend fun fetchSaleData (): MutableList<SaleProduct> {
        delay(1000)
        return saleProductsData
    }
}
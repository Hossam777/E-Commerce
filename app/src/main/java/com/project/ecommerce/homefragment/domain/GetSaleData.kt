package com.project.ecommerce.homefragment.domain

import com.project.ecommerce.homefragment.data.SaleDataRepository
import com.project.ecommerce.homefragment.data.SaleProduct

class GetSaleData (private val saleDataRepository: SaleDataRepository) {
    suspend fun fetchSaleData (): MutableList<SaleProduct> {
        return saleDataRepository.fetchSaleData()
    }
}
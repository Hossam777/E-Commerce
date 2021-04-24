package com.project.ecommerce.homefragment.domain

import com.project.ecommerce.homefragment.data.NewDataRepository
import com.project.ecommerce.homefragment.data.NewProduct

class GetNewData (private val newDataRepository: NewDataRepository) {
    suspend fun fetchNewData (): MutableList<NewProduct> {
        return newDataRepository.fetchNewData()
    }
}
package com.project.ecommerce.homefragment.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.project.ecommerce.homefragment.domain.GetNewData
import com.project.ecommerce.homefragment.domain.GetSaleData

@Suppress("UNCHECKED_CAST")
class HomeFragmentViewModelFactory (private val getSaleData: GetSaleData, private val getNewData: GetNewData)
    : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HomeFragmentViewModel(getSaleData, getNewData) as T
    }
}
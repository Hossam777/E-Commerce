package com.project.ecommerce.homescreen.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.project.ecommerce.homescreen.domain.LoadNewData
import com.project.ecommerce.homescreen.domain.LoadSaleData

@Suppress("UNCHECKED_CAST")
class HomeViewModelFactory (private val loadSaleData: LoadSaleData, private val loadNewData: LoadNewData)
    : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HomeViewModel(loadSaleData, loadNewData) as T
    }
}
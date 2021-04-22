package com.project.ecommerce.homescreen.presentation

import androidx.lifecycle.ViewModel
import com.project.ecommerce.homescreen.domain.LoadNewData
import com.project.ecommerce.homescreen.domain.LoadSaleData

class HomeViewModel(private val loadSaleData: LoadSaleData, private val loadNewData: LoadNewData)
    : ViewModel() {

}
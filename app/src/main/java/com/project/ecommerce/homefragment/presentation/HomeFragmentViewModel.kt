package com.project.ecommerce.homefragment.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.ecommerce.homefragment.data.NewProduct
import com.project.ecommerce.homefragment.data.SaleProduct
import com.project.ecommerce.homefragment.domain.GetNewData
import com.project.ecommerce.homefragment.domain.GetSaleData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeFragmentViewModel(private val getSaleData: GetSaleData, private val getNewData: GetNewData)
    : ViewModel() {
        var newProductsData: MutableLiveData<MutableList<NewProduct>> = MutableLiveData()
        var saleProductsData: MutableLiveData<MutableList<SaleProduct>> = MutableLiveData()
    fun fetchNewData(){
        viewModelScope.launch(Dispatchers.IO) {
            newProductsData.postValue(getNewData.fetchNewData())
        }
    }
    fun fetchSaleData(){
        viewModelScope.launch(Dispatchers.IO) {
            saleProductsData.postValue(getSaleData.fetchSaleData())
        }
    }
}
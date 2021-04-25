package com.project.ecommerce.shopfragment.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.ecommerce.shopfragment.data.ListItem
import com.project.ecommerce.shopfragment.domain.GetShopLists
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShopFragmentViewModel(private val getShopLists: GetShopLists)
    : ViewModel() {
    var radioSelected: MutableLiveData<String> = MutableLiveData()
    var shopLists: MutableLiveData<MutableList<MutableList<ListItem>>> = MutableLiveData()
    fun fetchShopLists (){
        viewModelScope.launch(Dispatchers.IO) {
            shopLists.postValue(getShopLists.getShopLists())
        }
    }
}
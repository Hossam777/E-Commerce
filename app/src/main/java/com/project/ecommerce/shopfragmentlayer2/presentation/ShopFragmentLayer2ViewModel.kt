package com.project.ecommerce.shopfragmentlayer2.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.ecommerce.shopfragmentlayer2.data.Category
import com.project.ecommerce.shopfragmentlayer2.domain.GetCategoriesList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShopFragmentLayer2ViewModel (private val getCategoriesList: GetCategoriesList)
    : ViewModel() {
    var categories: MutableLiveData<MutableList<Category>> = MutableLiveData()
        fun fetchCategories (){
            viewModelScope.launch (Dispatchers.IO) {
                categories.postValue(getCategoriesList.getCategories())
            }
        }
}
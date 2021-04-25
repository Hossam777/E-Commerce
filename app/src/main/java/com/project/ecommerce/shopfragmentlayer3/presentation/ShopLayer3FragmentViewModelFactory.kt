package com.project.ecommerce.shopfragmentlayer3.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.project.ecommerce.shopfragmentlayer3.domain.GetProductsByFilter

@Suppress("UNCHECKED_CAST")
class ShopFragmentLayer3ViewModelFactory (private val getProductsByFilter: GetProductsByFilter)
    : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ShopLayer3FragmentViewModel(getProductsByFilter) as T
    }
}
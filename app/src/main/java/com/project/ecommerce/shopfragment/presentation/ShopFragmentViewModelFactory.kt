package com.project.ecommerce.shopfragment.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.project.ecommerce.shopfragment.domain.GetShopLists

@Suppress("UNCHECKED_CAST")
class ShopFragmentViewModelFactory (private val getShopLists: GetShopLists)
    : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ShopFragmentViewModel(getShopLists) as T
    }
}
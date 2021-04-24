package com.project.ecommerce.shopfragment.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

@Suppress("UNCHECKED_CAST")
class ShopFragmentViewModelFactory ()
    : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ShopFragmentViewModel() as T
    }
}
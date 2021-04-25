package com.project.ecommerce.shopfragmentlayer2.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.project.ecommerce.shopfragmentlayer2.domain.GetCategoriesList

@Suppress("UNCHECKED_CAST")
class ShopFragmentLayer2ViewModelFactory (private val getCategoriesList: GetCategoriesList)
    : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ShopFragmentLayer2ViewModel(getCategoriesList) as T
    }
}
package com.project.ecommerce.shopfragmentlayer2.flow

import androidx.fragment.app.FragmentManager

interface ShopCategoriesFlow {
    fun openShopFragmentLayer3(supportFragmentManager: FragmentManager?, name: String, id: String)
}
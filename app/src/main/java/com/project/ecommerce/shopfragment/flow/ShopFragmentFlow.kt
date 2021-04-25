package com.project.ecommerce.shopfragment.flow

import androidx.fragment.app.FragmentManager

interface ShopFragmentFlow {
    fun openShopFragmentLayer2(supportFragmentManager: FragmentManager?, itemType: String, itemCategory: String, itemID: String)
}
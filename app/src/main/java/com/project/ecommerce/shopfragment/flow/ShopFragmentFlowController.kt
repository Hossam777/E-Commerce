package com.project.ecommerce.shopfragment.flow

import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import com.project.ecommerce.R
import com.project.ecommerce.shopfragment.presentation.ShopFragment
import com.project.ecommerce.shopfragmentlayer2.presentation.ShopLayer2Fragment

class ShopFragmentFlowController()
    : ShopFragmentFlow {
    override fun openShopFragmentLayer2(supportFragmentManager: FragmentManager?, itemType: String, itemCategory: String, itemID: String) {
        if (supportFragmentManager?.findFragmentByTag("ShopFragmentLayer2") == null){
            val arguments = Bundle()
            arguments.putString("type", itemType)
            arguments.putString("category", itemCategory)
            arguments.putString("id", itemID)
            val fragment = ShopLayer2Fragment()
            fragment.arguments = arguments
            supportFragmentManager?.commit {
                add(R.id.shopFragmentFrameLayout, fragment, "ShopFragmentLayer2").addToBackStack("ShopFragmentFrameLayout")
            }
        }
    }
}
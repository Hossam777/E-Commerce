package com.project.ecommerce.shopfragmentlayer2.flow

import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import com.project.ecommerce.R
import com.project.ecommerce.shopfragmentlayer3.presentation.ShopLayer3Fragment

class ShopCategoriesFlowController()
    : ShopCategoriesFlow {
    override fun openShopFragmentLayer3(supportFragmentManager: FragmentManager?, name: String, id: String) {
        if (supportFragmentManager?.findFragmentByTag("ShopFragmentLayer3") == null){
            val arguments = Bundle()
            arguments.putString("name", name)
            arguments.putString("id", id)
            val fragment = ShopLayer3Fragment()
            fragment.arguments = arguments
            supportFragmentManager?.commit {
                add(R.id.shop_layer2_fragment, fragment, "ShopFragmentLayer3").addToBackStack("shop_layer2_fragment")
            }
        }
    }
}
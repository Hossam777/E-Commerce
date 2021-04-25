package com.project.ecommerce.shopfragment.flow

import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit

class ShopFragmentFlowController(private var supportFragmentManager: FragmentManager)
    : ShopFragmentFlow {
    override fun openShopFragmentStep2(itemType: String, itemCategory: String, itemID: String) {
        var arguments = Bundle()
        arguments.putString("type", itemType)
        arguments.putString("category", itemCategory)
        arguments.putString("id", itemID)
        //var fragment =
        supportFragmentManager.commit {
            //add(R.id.)
        }
    }
}
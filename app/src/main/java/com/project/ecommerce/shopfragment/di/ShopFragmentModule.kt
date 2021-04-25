package com.project.ecommerce.shopfragment.di

import androidx.fragment.app.FragmentManager
import com.project.ecommerce.shopfragment.data.ShopListRepository
import com.project.ecommerce.shopfragment.domain.GetShopLists
import com.project.ecommerce.shopfragment.flow.ShopFragmentFlowController
import com.project.ecommerce.shopfragment.presentation.ShopFragmentViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.generic.*

val shopFragmentModule = Kodein.Module("ShopFragmentModule"){
    bind<ShopListRepository>() with singleton { ShopListRepository() }
    bind<GetShopLists>() with singleton { GetShopLists(instance()) }
    bind<ShopFragmentViewModelFactory>() with provider { ShopFragmentViewModelFactory(instance()) }
    bind<ShopFragmentFlowController>() with  provider { ShopFragmentFlowController() }
}
package com.project.ecommerce.shopfragmentlayer3.di

import com.project.ecommerce.shopfragmentlayer3.data.ProductsRepository
import com.project.ecommerce.shopfragmentlayer3.domain.GetProductsByFilter
import com.project.ecommerce.shopfragmentlayer3.flow.ShopProductsFlowController
import com.project.ecommerce.shopfragmentlayer3.presentation.ShopFragmentLayer3ViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

val shopFragmentLayer3Module = Kodein.Module ("ShopFragmentLayer3Module") {
    bind<ProductsRepository>() with singleton { ProductsRepository() }
    bind<GetProductsByFilter>() with singleton { GetProductsByFilter(instance()) }
    bind<ShopFragmentLayer3ViewModelFactory>() with provider { ShopFragmentLayer3ViewModelFactory(instance()) }
    bind<ShopProductsFlowController>() with provider { ShopProductsFlowController() }
}
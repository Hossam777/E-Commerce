package com.project.ecommerce.shopfragmentlayer2.di

import com.project.ecommerce.shopfragmentlayer2.data.ShopCategoriesRepository
import com.project.ecommerce.shopfragmentlayer2.domain.GetCategoriesList
import com.project.ecommerce.shopfragmentlayer2.flow.ShopCategoriesFlowController
import com.project.ecommerce.shopfragmentlayer2.presentation.ShopFragmentLayer2ViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.generic.*

val shopFragmentLayer2Module = Kodein.Module("ShopFragmentLayer2Module"){
    bind<ShopCategoriesRepository>() with singleton { ShopCategoriesRepository() }
    bind<GetCategoriesList>() with singleton { GetCategoriesList(instance()) }
    bind<ShopFragmentLayer2ViewModelFactory>() with provider { ShopFragmentLayer2ViewModelFactory(instance()) }
    bind<ShopCategoriesFlowController>() with provider { ShopCategoriesFlowController() }
}
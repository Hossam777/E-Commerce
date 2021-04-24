package com.project.ecommerce.shopfragment.di

import com.project.ecommerce.shopfragment.presentation.ShopFragmentViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.provider

val shopFragmentModule = Kodein.Module("ShopFragmentModule"){
    bind<ShopFragmentViewModelFactory>() with provider { ShopFragmentViewModelFactory() }
}
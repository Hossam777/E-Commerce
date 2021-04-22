package com.project.ecommerce.homescreen.di

import com.project.ecommerce.homescreen.domain.LoadNewData
import com.project.ecommerce.homescreen.domain.LoadSaleData
import com.project.ecommerce.homescreen.presentation.HomeViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

val homeModule = Kodein.Module("HomeModule"){
    bind<LoadSaleData>() with singleton { LoadSaleData() }
    bind<LoadNewData>() with singleton { LoadNewData() }
    bind<HomeViewModelFactory>() with provider { HomeViewModelFactory(instance(), instance()) }
}
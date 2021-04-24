package com.project.ecommerce.homefragment.di

import com.project.ecommerce.homefragment.data.NewDataRepository
import com.project.ecommerce.homefragment.data.SaleDataRepository
import com.project.ecommerce.homefragment.domain.GetNewData
import com.project.ecommerce.homefragment.domain.GetSaleData
import com.project.ecommerce.homefragment.presentation.HomeFragmentViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

val homeFragmentModule = Kodein.Module("HomeFragmentModule"){
    bind<NewDataRepository>() with singleton { NewDataRepository() }
    bind<SaleDataRepository>() with singleton { SaleDataRepository() }
    bind<GetSaleData>() with singleton { GetSaleData(instance()) }
    bind<GetNewData>() with singleton { GetNewData(instance()) }
    bind<HomeFragmentViewModelFactory>() with provider { HomeFragmentViewModelFactory(instance(), instance()) }
}
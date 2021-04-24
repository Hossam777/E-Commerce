package com.project.ecommerce.homescreen.di

import com.project.ecommerce.homescreen.presentation.HomeViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.provider

val homeModule = Kodein.Module("HomeModule"){
    bind<HomeViewModelFactory>() with provider { HomeViewModelFactory() }
}
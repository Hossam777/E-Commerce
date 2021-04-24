package com.project.ecommerce.app

import android.app.Application
import com.project.ecommerce.homefragment.di.homeFragmentModule
import com.project.ecommerce.homescreen.di.homeModule
import com.project.ecommerce.shopfragment.di.shopFragmentModule
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule

class application: Application(), KodeinAware {
    override val kodein = Kodein{
        import(androidXModule(this@application))
        import(homeModule)
        import(homeFragmentModule)
        import(shopFragmentModule)
    }

}
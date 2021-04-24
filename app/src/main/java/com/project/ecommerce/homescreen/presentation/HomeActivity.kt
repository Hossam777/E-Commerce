package com.project.ecommerce.homescreen.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.project.ecommerce.R
import com.project.ecommerce.databinding.ActivityHomeBinding
import com.project.ecommerce.homefragment.presentation.HomeFragment
import org.kodein.di.android.kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.instance

class HomeActivity : AppCompatActivity(), KodeinAware {

    override val kodein by kodein()
    private val viewModelFactory: HomeViewModelFactory by instance()
    private lateinit var viewModel: HomeViewModel
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        viewModel = ViewModelProvider(this, viewModelFactory).get(HomeViewModel::class.java)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        binding.bottomNavigation.setOnNavigationItemSelectedListener{ item -> onNavigationSelected(item)}
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add<HomeFragment>(R.id.homeScreenFragment)
        }
    }

    private fun onNavigationSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.home -> {
                supportFragmentManager.commit {
                    replace<HomeFragment>(R.id.homeScreenFragment)
                }
            }
            R.id.shop -> {
            }
            R.id.bag -> {
            }
            R.id.favourite -> {
            }
            R.id.profile -> {
            }
            else -> return false
        }
        return true
    }

}
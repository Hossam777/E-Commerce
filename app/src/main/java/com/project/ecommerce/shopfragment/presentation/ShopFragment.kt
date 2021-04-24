package com.project.ecommerce.shopfragment.presentation

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.project.ecommerce.R
import com.project.ecommerce.databinding.FragmentShopBinding
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance

class ShopFragment : Fragment(), KodeinAware {


    override val kodein by kodein()
    private val viewModelFactory: ShopFragmentViewModelFactory by instance()
    private lateinit var viewModel: ShopFragmentViewModel
    private lateinit var binding: FragmentShopBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shop, container, false)
        viewModel = ViewModelProvider(this, viewModelFactory).get(ShopFragmentViewModel::class.java)
        var view = binding.root
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    companion object {
        fun newInstance() = ShopFragment()
    }

}
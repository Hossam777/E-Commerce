package com.project.ecommerce.shopfragmentlayer3.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.project.ecommerce.R
import com.project.ecommerce.databinding.FragmentShopLayer2Binding
import com.project.ecommerce.databinding.FragmentShopLayer3Binding
import com.project.ecommerce.shopfragmentlayer2.flow.ShopCategoriesFlowController
import com.project.ecommerce.shopfragmentlayer2.presentation.ShopFragmentLayer2ViewModel
import com.project.ecommerce.shopfragmentlayer2.presentation.ShopFragmentLayer2ViewModelFactory
import com.project.ecommerce.shopfragmentlayer3.flow.ShopProductsFlow
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance

class ShopLayer3Fragment : Fragment(), KodeinAware {

    override val kodein by kodein()
    private val viewModelFactory: ShopFragmentLayer3ViewModelFactory by instance()
    private val flowController: ShopProductsFlow by instance()
    private lateinit var viewModel: ShopLayer3FragmentViewModel
    private lateinit var binding: FragmentShopLayer3Binding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shop_layer3, container, false)
        viewModel = ViewModelProvider(this, viewModelFactory).get(ShopLayer3FragmentViewModel::class.java)
        val view = binding.root
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                ShopLayer3Fragment()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}
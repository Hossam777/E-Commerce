package com.project.ecommerce.homefragment.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.project.ecommerce.R
import com.project.ecommerce.databinding.FragmentHomeBinding
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance

class HomeFragment : Fragment(), KodeinAware {
    override val kodein by kodein()
    private val viewModelFactory: HomeFragmentViewModelFactory by instance()
    private lateinit var viewModel: HomeFragmentViewModel
    private lateinit var binding: FragmentHomeBinding

    private lateinit var newDataAdapter:HomeFragmentRecyclerViewAdapter
    private lateinit var saleDataAdapter:HomeFragmentRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        viewModel = ViewModelProvider(this, viewModelFactory).get(HomeFragmentViewModel::class.java)
        var view = binding.root
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        initNewDataAdapter()
        subscribeOnNewData()
        viewModel.fetchNewData()
        initSaleDataAdapter()
        subscribeOnSaleData()
        viewModel.fetchSaleData()
        return view
    }

    private fun initNewDataAdapter() {
        binding.newDataRecycler.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        newDataAdapter = HomeFragmentRecyclerViewAdapter(resources, true, {

        }) {

        }
        binding.newDataRecycler.adapter = newDataAdapter
    }

    private fun subscribeOnNewData() {
        viewModel.newProductsData.observe(viewLifecycleOwner, {
            newDataAdapter.setNewProducts(it)
        })
    }

    private fun initSaleDataAdapter() {
        binding.saleDataRecycler.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        saleDataAdapter = HomeFragmentRecyclerViewAdapter(resources, false, {

        }) {

        }
        binding.saleDataRecycler.adapter = saleDataAdapter
    }

    private fun subscribeOnSaleData() {
        viewModel.saleProductsData.observe(viewLifecycleOwner, {
            saleDataAdapter.setSaleProducts(it)
        })
    }

    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment()
    }

}
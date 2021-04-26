package com.project.ecommerce.shopfragment.presentation

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.project.ecommerce.R
import com.project.ecommerce.databinding.FragmentShopBinding
import com.project.ecommerce.shopfragment.flow.ShopFragmentFlowController
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance

class ShopFragment : Fragment(), KodeinAware {

    override val kodein by kodein()
    private val viewModelFactory: ShopFragmentViewModelFactory by instance()
    private val flowController: ShopFragmentFlowController by instance()
    private lateinit var viewModel: ShopFragmentViewModel
    private lateinit var binding: FragmentShopBinding
    private lateinit var shopRecycler: ShopFragmentRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shop, container, false)
        viewModel = ViewModelProvider(this, viewModelFactory).get(ShopFragmentViewModel::class.java)
        val view = binding.root
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.radioSelected.postValue("Women's")
        setupToolBar()
        binding.radioGroup.setOnCheckedChangeListener { _, checkedId -> radioOnCheckedChangeListener(checkedId) }
        viewModel.fetchShopLists()
        initShopRecycler()
        subscribeOnShopLists()
        return view
    }

    private fun initShopRecycler() {
        shopRecycler = ShopFragmentRecyclerViewAdapter(){
            flowController.openShopFragmentLayer2(
                    activity?.supportFragmentManager,
                    viewModel.radioSelected.value.toString(),
                    it.name,
                    it.id
            )
        }
        binding.shopRecycler.layoutManager = LinearLayoutManager(context)
        binding.shopRecycler.adapter = shopRecycler
    }

    private fun subscribeOnShopLists() {
        viewModel.shopLists.observe(viewLifecycleOwner, {
            shopRecycler.setShopList(it[0])
        })
    }

    private fun radioOnCheckedChangeListener(checkedId: Int) {
        when (checkedId){
            R.id.radioButtonWomen -> {
                viewModel.radioSelected.postValue("Women's")
                shopRecycler.setShopList(viewModel.shopLists.value?.get(0))
            }
            R.id.radioButtonMen -> {
                viewModel.radioSelected.postValue("Men's")
                shopRecycler.setShopList(viewModel.shopLists.value?.get(1))
            }
            R.id.radioButtonKids -> {
                viewModel.radioSelected.postValue("Kids's")
                shopRecycler.setShopList(viewModel.shopLists.value?.get(2))
            }
        }
    }

    private fun setupToolBar() {
        binding.toolBar.findViewById<TextView>(R.id.toolBar_title).text = resources.getText(R.string.categories)
        binding.toolBar.findViewById<ImageButton>(R.id.toolBar_backBtn).visibility = View.INVISIBLE
        binding.toolBar.findViewById<ImageButton>(R.id.toolBar_searchBtn).visibility = View.INVISIBLE
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    companion object {
        fun newInstance() = ShopFragment()
    }


}
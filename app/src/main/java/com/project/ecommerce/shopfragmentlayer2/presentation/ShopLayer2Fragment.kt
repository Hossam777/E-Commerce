package com.project.ecommerce.shopfragmentlayer2.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.commit
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.project.ecommerce.R
import com.project.ecommerce.databinding.FragmentShopLayer2Binding
import com.project.ecommerce.shopfragmentlayer2.flow.ShopCategoriesFlowController
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance

class ShopLayer2Fragment : Fragment(), KodeinAware {

    override val kodein by kodein()
    private val viewModelFactory: ShopFragmentLayer2ViewModelFactory by instance()
    private val flowController: ShopCategoriesFlowController by instance()
    private lateinit var viewModel: ShopFragmentLayer2ViewModel
    private lateinit var binding: FragmentShopLayer2Binding
    private lateinit var categoriesRecycler:ShopLayer2FragmentRecyclerViewAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shop_layer2, container, false)
        viewModel = ViewModelProvider(this, viewModelFactory).get(ShopFragmentLayer2ViewModel::class.java)
        val view = binding.root
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        setupToolBar()
        initCategoriesRecycler(arguments?.getString("type")!!)
        viewModel.fetchCategories()
        subscribeOnCategories()

        return view
    }

    private fun initCategoriesRecycler(type: String) {
        categoriesRecycler = ShopLayer2FragmentRecyclerViewAdapter {
            flowController.openShopFragmentLayer3(
                    activity?.supportFragmentManager,
                    type,
                    it.name,
                    it.id
            )
        }
        binding.categoriesRecycler.layoutManager = LinearLayoutManager(context)
        binding.categoriesRecycler.adapter = categoriesRecycler
    }

    private fun subscribeOnCategories() {
        viewModel.categories.observe(viewLifecycleOwner, {
            categoriesRecycler.setCategories(it)
        })
    }

    private fun setupToolBar() {
        binding.toolBar.findViewById<TextView>(R.id.toolBar_title).text = resources.getText(R.string.categories)
        var fragment = this
        binding.toolBar.findViewById<ImageButton>(R.id.toolBar_backBtn).setOnClickListener{
            activity?.supportFragmentManager?.commit{
                show(activity?.supportFragmentManager?.findFragmentByTag("ShopFragment")!!)
                remove(fragment)
            }
        }
        binding.toolBar.findViewById<ImageButton>(R.id.toolBar_searchBtn).visibility = View.INVISIBLE
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                ShopLayer2Fragment()
    }
}
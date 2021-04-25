package com.project.ecommerce.shopfragmentlayer2.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.ecommerce.databinding.RecyclerShopLayer2FragmentBinding
import com.project.ecommerce.shopfragmentlayer2.data.Category

class ShopLayer2FragmentRecyclerViewAdapter (val onItemClicked:(Category)->Unit)
    : RecyclerView.Adapter<ShopLayer2FragmentRecyclerViewAdapter.ShopLayer2FragmentRecyclerViewHolder>() {
    private var categories: MutableList<Category> = mutableListOf()

    override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
    ): ShopLayer2FragmentRecyclerViewHolder {
        val inflate = LayoutInflater.from(parent.context)
        val binding = RecyclerShopLayer2FragmentBinding.inflate(inflate, parent, false)
        return ShopLayer2FragmentRecyclerViewHolder(binding)
    }

    fun setCategories(categories: MutableList<Category>) {
        this.categories = categories
        notifyDataSetChanged()
    }


    override fun onBindViewHolder(holder: ShopLayer2FragmentRecyclerViewHolder, position: Int) {
        holder.binding.categoryName.text = categories[position].name
        holder.binding.root.setOnClickListener { onItemClicked(categories[position]) }
    }


    override fun getItemCount(): Int {
        return categories.size
    }

    inner class ShopLayer2FragmentRecyclerViewHolder(
            val binding: RecyclerShopLayer2FragmentBinding
    ) : RecyclerView.ViewHolder(binding.root) {}
}
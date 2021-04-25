package com.project.ecommerce.shopfragment.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.ecommerce.databinding.RecyclerShopFragmentBinding
import com.project.ecommerce.shopfragment.data.ListItem
import com.squareup.picasso.Picasso

class ShopFragmentRecyclerViewAdapter (val onItemClicked:(ListItem)->Unit)
    : RecyclerView.Adapter<ShopFragmentRecyclerViewAdapter.ShopFragmentRecyclerViewHolder>()
{
    private var shopList: MutableList<ListItem> = mutableListOf()

    override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
    ): ShopFragmentRecyclerViewHolder {
        val inflate = LayoutInflater.from(parent.context)
        val binding = RecyclerShopFragmentBinding.inflate(inflate, parent, false)
        return ShopFragmentRecyclerViewHolder(binding)
    }

    fun setShopList(shopList: MutableList<ListItem>?) {
        if(shopList != null){
            this.shopList = shopList
            notifyDataSetChanged()
        }
    }


    override fun onBindViewHolder(holder: ShopFragmentRecyclerViewHolder, position: Int) {
        holder.binding.shopName.text = shopList[position].name
        Picasso.get().load(shopList[position].bannerLink).into(holder.binding.shopBanner)
        holder.binding.root.setOnClickListener { onItemClicked(shopList[position]) }
    }


    override fun getItemCount(): Int {
        return shopList.size
    }

    inner class ShopFragmentRecyclerViewHolder(
            val binding: RecyclerShopFragmentBinding
    ): RecyclerView.ViewHolder(binding.root){}
}
package com.project.ecommerce.homefragment.presentation

import android.content.res.Resources
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.ecommerce.R
import com.project.ecommerce.databinding.RecyclerHomeFragmentBinding
import com.project.ecommerce.homefragment.data.NewProduct
import com.project.ecommerce.homefragment.data.SaleProduct
import com.squareup.picasso.Picasso

class HomeFragmentRecyclerViewAdapter(private val resources: Resources,
                                      private val isNewRecycler: Boolean,
                                      val onItemClicked:(Int)->Unit,
                                      val onFavClicked:(Int)->Unit)
    : RecyclerView.Adapter<HomeFragmentRecyclerViewAdapter.HomeFragmentRecyclerViewHolder>()
{
    var newProductsData: MutableList<NewProduct> = mutableListOf()
    var saleProductsData: MutableList<SaleProduct> = mutableListOf()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HomeFragmentRecyclerViewHolder {
        val inflate = LayoutInflater.from(parent.context)
        val binding = RecyclerHomeFragmentBinding.inflate(inflate, parent, false)
        return HomeFragmentRecyclerViewHolder(binding)
    }

    fun setNewProducts(newProductsData: MutableList<NewProduct>) {
        this.newProductsData = newProductsData
        notifyDataSetChanged()
    }

    fun setSaleProducts(saleProductsData: MutableList<SaleProduct>) {
        this.saleProductsData = saleProductsData
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: HomeFragmentRecyclerViewHolder, position: Int) {
        holder.binding.productOldPrice.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
        if(isNewRecycler) {
            showNewDataItem(holder, position)
        }else{
            showSaleDataItem(holder, position)
        }
    }

    private fun showSaleDataItem(holder: HomeFragmentRecyclerViewAdapter.HomeFragmentRecyclerViewHolder, position: Int) {
        holder.binding.productBannerFlag.background = resources.getDrawable(R.drawable.product_banner_flag_hot)
        holder.binding.productOldPrice.visibility = View.VISIBLE
        Picasso.get().load(saleProductsData[position].bannerLink).into(holder.binding.productBanner)
        holder.binding.productBannerFlag.text = "-${saleProductsData[position].discount}%"
        holder.binding.productRating.rating = saleProductsData[position].rating.toFloat() / 2
        holder.binding.productRatingText.text = "(${saleProductsData[position].rating.toString()})"
        holder.binding.productBrand.text = saleProductsData[position].brand
        holder.binding.productName.text = saleProductsData[position].name
        holder.binding.productOldPrice.text = "${saleProductsData[position].price}$"
        holder.binding.productNewPrice.text = "${saleProductsData[position].price - 
                (saleProductsData[position].price * (saleProductsData[position].discount / 100))}$"
        holder.binding.root.setOnClickListener{onItemClicked(position)}
        holder.binding.favouriteBtn.setOnClickListener{onFavClicked(position)}
    }

    private fun showNewDataItem(holder: HomeFragmentRecyclerViewHolder, position: Int) {
        Picasso.get().load(newProductsData[position].bannerLink).into(holder.binding.productBanner);
        holder.binding.productRating.rating = newProductsData[position].rating.toFloat() / 2
        holder.binding.productRatingText.text = "(${newProductsData[position].rating.toString()})"
        holder.binding.productBrand.text = newProductsData[position].brand
        holder.binding.productName.text = newProductsData[position].name
        holder.binding.productNewPrice.text = "${newProductsData[position].price}$"
        holder.binding.root.setOnClickListener{onItemClicked(position)}
        holder.binding.favouriteBtn.setOnClickListener{onFavClicked(position)}
    }

    override fun getItemCount(): Int {
        return if (newProductsData.size > 0)
            newProductsData.size
        else
            saleProductsData.size
    }

    inner class HomeFragmentRecyclerViewHolder(
        val binding: RecyclerHomeFragmentBinding
    ): RecyclerView.ViewHolder(binding.root){}
}
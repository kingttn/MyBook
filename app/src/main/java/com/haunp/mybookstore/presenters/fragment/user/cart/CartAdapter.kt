package com.haunp.mybookstore.presenters.fragment.user.cart

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.haunp.mybookstore.databinding.ItemCartBinding
import com.haunp.mybookstore.domain.entity.BookEntity
import com.haunp.mybookstore.domain.entity.CartEntity

class CartAdapter() : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {
    var onItemClicked: (CartEntity) -> Unit = {}
    private val cartItems = mutableListOf<BookEntity>()

    fun submitList(newCartItems: List<BookEntity>) {
        cartItems.clear()
        cartItems.addAll(newCartItems)
        Log.d("hau.np", "submitList: ${cartItems.size} items added")
        notifyDataSetChanged()
    }

    inner class CartViewHolder(private val binding: ItemCartBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(cartItem: BookEntity) {
            binding.apply {
                Glide.with(itemView.context)
                    .load(cartItem.imageUri)
                    .into(imgIcon)
                tvTitle.text = cartItem.title
                tvPrice.text = cartItem.price.toString()
                tvQuantity.text = cartItem.quantity.toString()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val binding = ItemCartBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CartViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.bind(cartItems[position])
    }

    override fun getItemCount(): Int = cartItems.size
}

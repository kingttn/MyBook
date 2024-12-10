package com.haunp.mybookstore.presenters.fragment.user.cart

import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.haunp.mybookstore.databinding.CartFragmentBinding
import com.haunp.mybookstore.databinding.CategoryUserFragmentBinding
import com.haunp.mybookstore.domain.entity.BookEntity
import com.haunp.mybookstore.presenters.base.BaseFragment
import com.haunp.mybookstore.presenters.fragment.main.MainActivity
import com.haunp.mybookstore.presenters.fragment.user.home.HomeFragment
import org.koin.android.ext.android.inject

class CartFragment : BaseFragment<CartFragmentBinding>() {

    private val viewModel: CartViewModel by inject()
    override var isTerminalBackKeyActive: Boolean = true
    override fun getDataBinding(): CartFragmentBinding {
        return CartFragmentBinding.inflate(layoutInflater)
    }
    var adapter = CartAdapter()
    override fun initView() {
        Log.d("hau.np", "initView: ")
        binding{
            rVCart.layoutManager = LinearLayoutManager(context)
            rVCart.adapter = adapter
            viewModel.cartItems.observe(viewLifecycleOwner) { cartIds ->
                Log.d("hau.np", "Cart IDs: $cartIds")

                val allBooks = viewModel.allBooks.value
                Log.d("hau.np", "All books: $allBooks")

                val cartBooks = allBooks?.filter { it.bookId in cartIds } ?: emptyList()
                adapter.submitList(cartBooks)
                Log.d("hau.np", "Filtered cartBooks: ${cartBooks.size}")
            }
        }
    }
}

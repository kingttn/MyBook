package com.haunp.mybookstore.presenters.fragment.user

import android.content.Context
import android.os.Bundle
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.haunp.mybookstore.databinding.BookDetailFragmentBinding
import com.haunp.mybookstore.domain.entity.BookEntity
import com.haunp.mybookstore.presenters.base.BaseFragment
import com.haunp.mybookstore.presenters.fragment.user.home.HomeAdapter

@Suppress("DEPRECATION")
class BookDetailFragment: BaseFragment<BookDetailFragmentBinding>() {
    private var book: BookEntity? = null
    override var isTerminalBackKeyActive: Boolean = true

    override fun getDataBinding(): BookDetailFragmentBinding {
        return BookDetailFragmentBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun initView() {
        val adapter = HomeAdapter()
        binding{
            book = arguments?.getParcelable("book")
            book?.let {
                nameBook.text = it.title
                priceBook.text = it.price.toString()
                authorBook.text = it.author
                descriptionBook.text = it.description
            }
        }
    }
    override fun initAction() {

    }
}
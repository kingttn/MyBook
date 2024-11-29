package com.haunp.mybookstore.presenters.fragment.admin.book

import android.os.Bundle
import android.view.View
import com.haunp.mybookstore.databinding.BookFragmentBinding
import com.haunp.mybookstore.domain.entity.BookEntity
import com.haunp.mybookstore.presenters.base.BaseFragment
import org.koin.android.ext.android.inject

class BookFragment : BaseFragment<BookFragmentBinding>() {
    override var isTerminalBackKeyActive: Boolean = true
    private val viewModel: BookViewModel by inject()

    override fun getDataBinding(): BookFragmentBinding {
        return BookFragmentBinding.inflate(layoutInflater)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }
    override fun initView() {
        binding{
            btnAdd.setOnClickListener {
                val title = edtTitle.text.toString()
                val author = edtAuthor.text.toString()
                val price = edtPrice.text.toString()
                val quantity = edtQuantity.text.toString()
                val category = edtCategory.text.toString()
                val size = edtSize.text.toString()
                val bookEntity = BookEntity(
                    title = title,
                    author = author,
                    price = price.toDouble(),
                    quantity = quantity.toInt(),
                    categoryId = 0,
                    size = size
                )
                viewModel.addBook(bookEntity)
                edtIdBook.setText("")
                edtTitle.setText("")
                edtAuthor.setText("")
                edtPrice.setText("")
                edtQuantity.setText("")
                edtCategory.setText("")
                edtSize.setText("")
            }
//            btnDel.setOnClickListener {
//                val id = edtIdBook.text.toString()
//                viewModel.deleteBook(id.toInt())
//                edtIdBook.setText("")
//            }
            btnUpdate.setOnClickListener {
                val id = edtIdBook.text.toString()
                val title = edtTitle.text.toString()
                val author = edtAuthor.text.toString()
                val price = edtPrice.text.toString()
                val quantity = edtQuantity.text.toString()
                val category = edtCategory.text.toString()
                val size = edtSize.text.toString()
                val bookEntity = BookEntity(
                    bookId = id.toInt(),
                    title = title,
                    author = author,
                    price = price.toDouble(),
                    quantity = quantity.toInt(),
                    categoryId = 0,
                    size = size
                )
                viewModel.updateBook(bookEntity)
            }
        }
    }


}
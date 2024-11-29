package com.haunp.mybookstore.presenters.fragment.admin.book

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.haunp.mybookstore.databinding.ItemBookBinding
import com.haunp.mybookstore.domain.entity.BookEntity


class BookAdapter : RecyclerView.Adapter<BookAdapter.BookViewHolder>() {
    private val books = mutableListOf<BookEntity>() // Danh sách dữ liệu hiển thị

    fun submitList(newBooks: List<BookEntity>){
        books.clear()
        books.addAll(newBooks)
        notifyDataSetChanged()
    }
    inner class BookViewHolder(private val binding: ItemBookBinding) :
            RecyclerView.ViewHolder(binding.root) {
                fun bind(book: BookEntity) {
                    binding.tvTittle.text = book.title
                    binding.tvRating.text = book.author
                    binding.tvPrice.text = book.price.toString()
                }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val binding = ItemBookBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return BookViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.bind(books[position])
    }

    override fun getItemCount(): Int = books.size
}
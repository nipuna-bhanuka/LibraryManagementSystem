package com.example.librarymanagementsystem.ui.book

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.librarymanagementsystem.data.Book.Book
import com.example.librarymanagementsystem.data.Book.BooksRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class BookDetailsViewModel(private val repository: BooksRepository) : ViewModel() {

    fun getBookDetails(bookId: Int): Flow<Book> {
        return repository.getBookStream(bookId)
    }

    fun deleteBook(bookId: Int) {
        viewModelScope.launch {
            repository.deleteBook(bookId)
        }
    }
}

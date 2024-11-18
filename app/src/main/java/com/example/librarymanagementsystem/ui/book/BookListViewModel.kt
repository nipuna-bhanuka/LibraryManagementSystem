package com.example.librarymanagementsystem.ui.book

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.librarymanagementsystem.data.Book.Book
import com.example.librarymanagementsystem.data.Book.BooksRepository
import com.example.librarymanagementsystem.data.Category.Category
import com.example.librarymanagementsystem.data.Category.CategoryRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class BookListViewModel(bookRepository: BooksRepository) : ViewModel(){

    val bookUiState: StateFlow<ViewBookUiState> =
        bookRepository.getAllBooksStream().map { ViewBookUiState(it) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = ViewBookUiState()
            )

    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }

}

data class ViewBookUiState(val bookList: List<Book> = listOf())
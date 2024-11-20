package com.example.librarymanagementsystem.ui.book

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.librarymanagementsystem.data.Book.Book
import com.example.librarymanagementsystem.data.Book.BooksRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class BookDetailsViewModel(
    private val savedStateHandle: SavedStateHandle,
    private val repository: BooksRepository) : ViewModel() {

    private val bookId: Int = savedStateHandle["bookId"] ?: 0

    fun deleteBook(book: Book) {
        viewModelScope.launch {
            repository.deleteBook(book)
        }
    }

    val bookUiState: StateFlow<ViewBookDetailsUiState> =
        repository.getBookStream(bookId)
            .map { book -> ViewBookDetailsUiState(bookDetails = book) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = ViewBookDetailsUiState()
            )



    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }
}

data class ViewBookDetailsUiState(
    val bookDetails: Book? = null // Make bookDetails nullable
)


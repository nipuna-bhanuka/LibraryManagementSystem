package com.example.librarymanagementsystem.ui.book

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.librarymanagementsystem.data.Book.Book
import com.example.librarymanagementsystem.data.Book.BooksRepository

class AddBookViewModel(
    private val booksRepository: BooksRepository, ) : ViewModel() {

    var bookUiState by mutableStateOf(BookUiState())
        private set

    fun updateUiState(bookDetails: BookDetails) {
        bookUiState = BookUiState(
            bookDetails = bookDetails,
            isEntryValid = bookDetails.title.isNotBlank()
                    && bookDetails.author.isNotBlank()
                    && bookDetails.description.isNotBlank())
    }

    suspend fun saveBook() {
        println("hiI :"+bookUiState.bookDetails)
        if(validateInput()){
            booksRepository.insertBook(bookUiState.bookDetails.toBook())
        }
    }

    private fun validateInput(uiState: BookDetails = bookUiState.bookDetails): Boolean {
        return with(uiState) {
            title.isNotBlank() && author.isNotBlank() && description.isNotBlank()
        }
    }
    }

data class BookUiState(
    val bookDetails: BookDetails = BookDetails(),
    val isEntryValid: Boolean = false
)

data class BookDetails(
    val id: Int = 0,
    val title: String = "",
    val author: String = "",
    val categoryId: Int? = null,
    val description: String = "",
    val isAvailable: Boolean = true,
    val isActive: Boolean = true,
)

fun BookDetails.toBook(): Book = Book(
    id = id,
    title = title,
    author = author,
    categoryId = categoryId?: 1,
    description = description,
    isAvailable = isAvailable,
    isActive = isActive
)
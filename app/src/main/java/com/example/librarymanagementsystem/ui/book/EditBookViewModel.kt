package com.example.librarymanagementsystem.ui.book

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.librarymanagementsystem.data.Book.BooksRepository
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.first

class EditBookViewModel(
    savedStateHandle: SavedStateHandle,
    private val booksRepository: BooksRepository
) : ViewModel() {


//    var bookUiState by mutableStateOf(BookUiState())
//        private set
//
//    private val bookId: Int = checkNotNull(savedStateHandle[EditBookDestination.bookIdArg])
//
//    init {
//        viewModelScope.launch {
//            bookUiState = booksRepository.getBookStream(bookId)
//                .filterNotNull()
//                .first()
//                .toBookUiState(true)
//        }
//    }
//
//    suspend fun updateBook() {
//        if (validateInput(bookUiState.bookDetails)) {
//            booksRepository.updateBook(bookUiState.bookDetails.toBook())
//        }
//    }
//
//    fun updateUiState(bookDetails: BookDetails) {
//        bookUiState =
//            BookUiState(bookDetails = bookDetails, isEntryValid = validateInput(bookDetails))
//    }
//
//    private fun validateInput(uiState: BookDetails = bookUiState.bookDetails): Boolean {
//        return with(uiState) {
//            title.isNotBlank() && author.isNotBlank() && description.isNotBlank()
//        }
//    }
}
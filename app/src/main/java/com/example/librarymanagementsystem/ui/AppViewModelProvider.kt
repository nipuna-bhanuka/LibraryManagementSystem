package com.example.librarymanagementsystem.ui

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.librarymanagementsystem.LibraryApplication
import com.example.librarymanagementsystem.ui.book.AddBookViewModel
import com.example.librarymanagementsystem.ui.book.BookDetailsViewModel
import com.example.librarymanagementsystem.ui.book.BookListViewModel
import com.example.librarymanagementsystem.ui.category.AddCategoryViewModel
import com.example.librarymanagementsystem.ui.category.BookCategoryViewModel


object AppViewModelProvider {
    val Factory = viewModelFactory {

        initializer {
            AddCategoryViewModel(libraryApplication().container.categoryRepository)
        }

        initializer {
            AddBookViewModel(libraryApplication().container.booksRepository)
        }

        initializer {
            BookCategoryViewModel(libraryApplication().container.categoryRepository)
        }

        initializer {
            BookListViewModel(
                savedStateHandle = this.createSavedStateHandle(),
                libraryApplication().container.booksRepository)
        }
        initializer {
            BookDetailsViewModel(
                savedStateHandle = this.createSavedStateHandle(),
                libraryApplication().container.booksRepository)
        }

    }
}


fun CreationExtras.libraryApplication(): LibraryApplication =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as LibraryApplication)
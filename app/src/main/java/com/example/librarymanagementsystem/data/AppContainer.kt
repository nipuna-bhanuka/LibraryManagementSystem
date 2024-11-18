package com.example.librarymanagementsystem.data

import android.content.Context
import com.example.librarymanagementsystem.data.Book.BooksRepository
import com.example.librarymanagementsystem.data.Book.OfflineBooksRepository
import com.example.librarymanagementsystem.data.Category.CategoryRepository
import com.example.librarymanagementsystem.data.Category.OfflineCategoryRepository

interface AppContainer {

    val categoryRepository : CategoryRepository
    val booksRepository : BooksRepository
}

/**
 * [AppContainer] implementation that provides instance of [OfflineItemsRepository]
 */
class AppDataContainer(private val context: Context) : AppContainer {

    override val categoryRepository: CategoryRepository by lazy {
        OfflineCategoryRepository(LibraryDatabase.getDatabase(context).categoryDao())
    }

    override val booksRepository: BooksRepository by lazy {
        OfflineBooksRepository(LibraryDatabase.getDatabase(context).bookDao())
    }
}
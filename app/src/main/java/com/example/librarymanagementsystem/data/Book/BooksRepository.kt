package com.example.librarymanagementsystem.data.Book

import kotlinx.coroutines.flow.Flow

interface BooksRepository{
    fun getAllBooksStream() : Flow<List<Book>>

    fun getBookStream(id : Int) : Flow<Book>

    fun getBooksByCategoryStream(cId : Int) : Flow<List<Book>>

    suspend fun insertCategory(book: Book)

    suspend fun deleteCategory(book: Book)

    suspend fun updateCategory(book: Book)
}
package com.example.librarymanagementsystem.data.Book

import kotlinx.coroutines.flow.Flow

class OfflineBooksRepository(private  val bookDao: BookDao) : BooksRepository{
    override fun getAllBooksStream(): Flow<List<Book>>
        = bookDao.getAllBooks()

    override fun getBookStream(id: Int): Flow<Book>
        = bookDao.getBook(id)

    override fun getBooksByCategoryStream(cId: Int): Flow<List<Book>>
        = bookDao.getBooksByCategory(cId)

    override suspend fun insertCategory(book: Book)
        = bookDao.insert(book)

    override suspend fun deleteCategory(book: Book)
        = bookDao.delete(book)

    override suspend fun updateCategory(book: Book)
        = bookDao.update(book)

}
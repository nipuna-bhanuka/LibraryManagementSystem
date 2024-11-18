package com.example.librarymanagementsystem.data.Book

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.librarymanagementsystem.data.Category.Category
import kotlinx.coroutines.flow.Flow

@Dao
interface BookDao{
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(book: Book)

    @Update
    suspend fun update(book: Book)

    @Delete
    suspend fun delete(book: Book)

    @Query("SELECT * from books WHERE id = :id")
    fun getBook(id: Int): Flow<Book>

    @Query("SELECT * from books ORDER BY title ASC")
    fun getAllBooks(): Flow<List<Book>>

    @Query("SELECT * from books WHERE category_Id = :cid ORDER BY title ASC")
    fun getBooksByCategory(cid: Int): Flow<List<Book>>
}
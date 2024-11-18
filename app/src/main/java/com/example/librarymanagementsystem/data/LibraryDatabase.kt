package com.example.librarymanagementsystem.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.librarymanagementsystem.data.Book.Book
import com.example.librarymanagementsystem.data.Book.BookDao
import com.example.librarymanagementsystem.data.Category.Category
import com.example.librarymanagementsystem.data.Category.CategoryDao

@Database(
    entities = [
        Category::class ,
        Book::class],
    version = 2,
    exportSchema = false)
abstract class LibraryDatabase : RoomDatabase() {

    abstract fun categoryDao() : CategoryDao
    abstract fun bookDao() : BookDao

    companion object {
        @Volatile
        private var Instance: LibraryDatabase? = null

        fun getDatabase(context: Context): LibraryDatabase {
            // if the Instance is not null, return it, otherwise create a new database instance.
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, LibraryDatabase::class.java, "library_database")
                    .build().also { Instance = it }
            }
        }
    }
}
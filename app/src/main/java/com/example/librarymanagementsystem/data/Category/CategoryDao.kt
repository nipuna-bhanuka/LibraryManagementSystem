package com.example.librarymanagementsystem.data.Category

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

interface CategoryDao{
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(category: Category)

    @Update
    suspend fun update(category: Category)

    @Delete
    suspend fun delete(category: Category)

    @Query("SELECT * from categories WHERE id = :id")
    fun getCategory(id: Int): Flow<Category>

    @Query("SELECT * from categories ORDER BY name ASC")
    fun getAllCategories(): Flow<List<Category>>
}
package com.example.librarymanagementsystem.data.Category

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface CategoryDao{
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(category: Category)

    @Update
    suspend fun update(category: Category)

    @Delete
    suspend fun delete(category: Category)

    @Query("SELECT * from categories WHERE id = :id")
    fun getCategory(id: Int): Flow<Category>

    @Query("""
        SELECT 
    c.id AS categoryId,
    c.name AS categoryName,
    c.description AS categoryDescription,
    COALESCE(b.bookCount, 0) AS noOfBooks
    FROM categories c
        LEFT JOIN (
        SELECT 
            category_Id,
            COUNT(id) AS bookCount
        FROM books
        WHERE is_Active = 1
    GROUP BY category_Id
) b ON c.id = b.category_Id
ORDER BY c.id DESC
    """)
    fun getAllCategories(): Flow<List<CategoryWithBookCount>>
}

data class CategoryWithBookCount(
    val categoryId: Int,
    val categoryName: String,
    val categoryDescription: String,
    val noOfBooks: Int
)

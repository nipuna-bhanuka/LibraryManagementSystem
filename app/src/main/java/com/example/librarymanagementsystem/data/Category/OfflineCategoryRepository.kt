package com.example.librarymanagementsystem.data.Category

import kotlinx.coroutines.flow.Flow

class OfflineCategoryRepository(private val categoryDao: CategoryDao) : CategoryRepository {
    override fun getAllCategoriesStream(): Flow<List<CategoryWithBookCount>>
        = categoryDao.getAllCategories()

    override fun getCategoryStream(id: Int): Flow<Category>
        = categoryDao.getCategory(id)

    override suspend fun insertCategory(category: Category)
        = categoryDao.insert(category)

    override suspend fun deleteCategory(category: Category)
        = categoryDao.delete(category)

    override suspend fun updateCategory(category: Category)
        = categoryDao.update(category)

}
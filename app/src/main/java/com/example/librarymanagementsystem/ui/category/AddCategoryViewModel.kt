package com.example.librarymanagementsystem.ui.category

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.librarymanagementsystem.data.Category.Category
import com.example.librarymanagementsystem.data.Category.CategoryRepository

class AddCategoryViewModel(private val categoryRepository: CategoryRepository) : ViewModel() {

    var categoryUiState by mutableStateOf(CategoryUiState())
        private set

    fun updateUiState(categoryDetails: CategoryDetails) {
        categoryUiState = CategoryUiState(
            categoryDetails = categoryDetails,
            isEntryValid = categoryDetails.name.isNotBlank() && categoryDetails.description.isNotBlank())
    }

    suspend fun saveCategory() {
        if(validateInput()){
            categoryRepository.insertCategory(categoryUiState.categoryDetails.toCategory())
            resetForm()
        }
    }

    private fun resetForm() {
        categoryUiState = CategoryUiState()
    }

    private fun validateInput(uiState: CategoryDetails = categoryUiState.categoryDetails): Boolean {
        return with(uiState) {
            name.isNotBlank() && name.isNotBlank() && description.isNotBlank()
        }
    }
}

data class CategoryUiState(
    val categoryDetails: CategoryDetails = CategoryDetails(),
    val isEntryValid: Boolean = false
)

data class CategoryDetails(
    val id: Int = 0,
    val name: String = "",
    val description: String = "",
    val isActive: Boolean = true,
)

fun CategoryDetails.toCategory(): Category = Category(
    id = id,
    name = name,
    description = description,
    isActive = isActive
)
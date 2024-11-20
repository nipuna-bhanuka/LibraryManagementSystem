package com.example.librarymanagementsystem.ui.category

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.librarymanagementsystem.data.Category.CategoryRepository
import com.example.librarymanagementsystem.data.Category.CategoryWithBookCount
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class BookCategoryViewModel(categoryRepository: CategoryRepository) : ViewModel(){

    val categoryUiState: StateFlow<ViewCategoryUiState> =
        categoryRepository.getAllCategoriesStream().map { ViewCategoryUiState(it) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = ViewCategoryUiState()
            )

    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }

}

data class ViewCategoryUiState(val categoryList: List<CategoryWithBookCount> = listOf())
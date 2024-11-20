package com.example.librarymanagementsystem.ui.book

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.librarymanagementsystem.LibraryManagementAppBar
import com.example.librarymanagementsystem.data.Book.Book
import com.example.librarymanagementsystem.ui.AppViewModelProvider
import kotlinx.coroutines.launch
import java.lang.reflect.Modifier

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun EditBookScreen(
    categoryId : Int,
    categoryName: String,
    bookId : Int,

    navigateBack: () -> Unit,
    onNavigateUp: () -> Unit,

    viewModel: EditBookViewModel = viewModel(factory = AppViewModelProvider.Factory)
){
    val coroutineScope = rememberCoroutineScope()
    Scaffold(
        topBar = { LibraryManagementAppBar("Edit Book Details") }
    ){
//        innerPadding ->
//        AddBookBody(
//            bookUiState = viewModel.bookUiState,
//            onBookValueChange = viewModel::updateUiState,
//            onSaveClick = {
//                coroutineScope.launch {
//                    viewModel.updateBook()
//                    navigateBack()
//                }
//            },
//            categoryName = TODO(),
//            categoryId = TODO(),
//        )
    }
}
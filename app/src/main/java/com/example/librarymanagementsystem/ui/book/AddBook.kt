package com.example.librarymanagementsystem.ui.book

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.librarymanagementsystem.LibraryManagementAppBar
import com.example.librarymanagementsystem.data.Category.Category
import com.example.librarymanagementsystem.ui.AppViewModelProvider
import com.example.librarymanagementsystem.ui.category.BookCategoryViewModel
import com.example.librarymanagementsystem.ui.category.CategoryUiState
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview
@Composable
fun AddBook(
    viewModel: AddBookViewModel = viewModel(factory = AppViewModelProvider.Factory),
){
    Column(modifier = Modifier) {

        val coroutineScope = rememberCoroutineScope()

        Scaffold(
            topBar = { LibraryManagementAppBar("Add Book") }
        ){
            AddBookBody(
                bookUiState = viewModel.bookUiState,
                onBookValueChange = viewModel::updateUiState,
                onSaveClick = {
                    coroutineScope.launch {
                        viewModel.saveBook()
                    }
                }
            )
        }
    }

}

@Composable
fun AddBookBody(
    bookUiState: BookUiState,
    onBookValueChange: (BookDetails) -> Unit,
    onSaveClick: () -> Unit,
){
    Column {

        BookInputForm(
            bookDetails = bookUiState.bookDetails,
            onValueChange = onBookValueChange,
            modifier = Modifier.fillMaxWidth()
        )
        Button(
            onClick = onSaveClick,
            shape = MaterialTheme.shapes.small,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Save New Book")
        }
    }
}

@Composable
fun BookInputForm(
    bookDetails: BookDetails,
    modifier: Modifier= Modifier,
    onValueChange: (BookDetails) -> Unit = {},
    enabled: Boolean = true
){

    Column(
        modifier = modifier.padding(top = 96.dp)
    ) {
        OutlinedTextField(
            value = bookDetails.title,
            onValueChange = { onValueChange(bookDetails.copy(title = it))},
            label = {
                Text("Book Title")
            },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )

        Spacer(modifier = Modifier.padding(vertical = 16.dp))

        OutlinedTextField(
            value = bookDetails.author,
            onValueChange = { onValueChange(bookDetails.copy(author = it))},
            label = {
                Text("Author of the Book")
            },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled
        )

        Spacer(modifier = Modifier.padding(vertical = 16.dp))

        OutlinedTextField(
            value = bookDetails.description,
            onValueChange = { onValueChange(bookDetails.copy(description = it))},
            label = {
                Text("About Book")
            },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled
        )

    }
}


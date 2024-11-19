package com.example.librarymanagementsystem.ui.book

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.librarymanagementsystem.LibraryManagementAppBar
import com.example.librarymanagementsystem.data.Category.Category
import com.example.librarymanagementsystem.ui.AppViewModelProvider
import com.example.librarymanagementsystem.ui.category.BookCategoryViewModel
import com.example.librarymanagementsystem.ui.category.CategoryUiState
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AddBook(
    navController: NavController,
    categoryId: Int?,
    categoryName: String?,
    viewModel: AddBookViewModel = viewModel(factory = AppViewModelProvider.Factory),
){
    Column(modifier = Modifier) {

        val coroutineScope = rememberCoroutineScope()

        Scaffold(
            topBar = { LibraryManagementAppBar("Add Book") }
        ){
            AddBookBody(
                categoryName= categoryName?: "",
                categoryId = categoryId?: 0,
                bookUiState = viewModel.bookUiState,
                onBookValueChange = viewModel::updateUiState,
                onSaveClick = {
                    println("cid5 $categoryId")
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
    categoryName: String,
    categoryId: Int,
    bookUiState: BookUiState,
    onBookValueChange: (BookDetails) -> Unit,
    onSaveClick: () -> Unit,
){
    Column(
        modifier = Modifier.padding(16.dp)
    ) {

        BookInputForm(
            categoryName= categoryName,
            categoryId = categoryId,
            bookDetails = bookUiState.bookDetails,
            onValueChange = onBookValueChange,
            modifier = Modifier.fillMaxWidth()
        )
        Button(
            onClick = onSaveClick,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Magenta,
                contentColor = Color.White
            ),
            shape = MaterialTheme.shapes.small,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Save New Book")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookInputForm(
    categoryId: Int,
    categoryName: String,
    bookDetails: BookDetails,
    modifier: Modifier = Modifier,
    onValueChange: (BookDetails) -> Unit = {},
    enabled: Boolean = true
) {
    Column(
        modifier = modifier.padding(top = 96.dp)
    ) {
        OutlinedTextField(
            value = bookDetails.title,
            onValueChange = { onValueChange(bookDetails.copy(title = it)) },
            label = { Text("Book Title") },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )

        Spacer(modifier = Modifier.padding(vertical = 16.dp))

        OutlinedTextField(
            value = bookDetails.author,
            onValueChange = { onValueChange(bookDetails.copy(author = it)) },
            label = { Text("Author of the Book") },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled
        )

        Spacer(modifier = Modifier.padding(vertical = 16.dp))

        // Read-only dropdown displaying the category name
        OutlinedTextField(
            value = categoryName,
            onValueChange = {}, // No interaction allowed
            readOnly = true,
            label = { Text("Category") },
            modifier = Modifier.fillMaxWidth(),
            enabled = false, // Completely disables interaction
            trailingIcon = { // Optional: show a locked icon
                Icon(imageVector = Icons.Default.Lock, contentDescription = "Read-only")
            }
        )

        Spacer(modifier = Modifier.padding(vertical = 16.dp))

        OutlinedTextField(
            value = bookDetails.description,
            onValueChange = { onValueChange(bookDetails.copy(description = it)) },
            label = { Text("About Book") },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled
        )

        Spacer(modifier = Modifier.padding(vertical = 16.dp))
    }
}



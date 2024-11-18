package com.example.librarymanagementsystem.ui.category

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.librarymanagementsystem.LibraryManagementAppBar
import com.example.librarymanagementsystem.ui.AppViewModelProvider
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview
@Composable
fun AddCategoryScreen(
    viewModel: AddCategoryViewModel = viewModel(factory = AppViewModelProvider.Factory)
){
    Column(
        modifier = Modifier) {

        val coroutineScope = rememberCoroutineScope()
        Scaffold(
            topBar = { LibraryManagementAppBar("Add Category") }
        ){
            AddCategoryBody(
                categoryUiState = viewModel.categoryUiState,
                onCategoryValueChange = viewModel::updateUiState,
                onSaveClick = {
                    coroutineScope.launch {
                        viewModel.saveCategory()
                    }
                }
            )
        }

    }
}

@Composable
fun AddCategoryBody(
    categoryUiState: CategoryUiState,
    onCategoryValueChange: (CategoryDetails) -> Unit,
    onSaveClick: () -> Unit,
){
    Column {
        CategoryInputForm(
            categoryDetails = categoryUiState.categoryDetails,
            onValueChange = onCategoryValueChange,
            modifier = Modifier.fillMaxWidth()
        )
        Button(
            onClick = onSaveClick,
            shape = MaterialTheme.shapes.small,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Save Category")
        }
    }
}

@Composable
fun CategoryInputForm(
    categoryDetails: CategoryDetails,
    modifier: Modifier= Modifier,
    onValueChange: (CategoryDetails) -> Unit = {},
    enabled: Boolean = true
){
    Column(
        modifier = modifier.padding(top = 96.dp)
    ) {
        OutlinedTextField(
            value = categoryDetails.name,
            onValueChange = { onValueChange(categoryDetails.copy(name = it))},
            label = {
                Text("Category Name")
            },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )

        Spacer(modifier = Modifier.padding(vertical = 16.dp))

        OutlinedTextField(
            value = categoryDetails.description,
            onValueChange = { onValueChange(categoryDetails.copy(description = it))},
            label = {
                Text("Description")
            },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled
        )
    }
}
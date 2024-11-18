package com.example.librarymanagementsystem.ui.category

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.librarymanagementsystem.LibraryManagementAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun AddCategory(){
    Column(modifier = Modifier) {
        LibraryManagementAppBar("Add Category")

        Column(modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 8.dp)
        ){
            var categoryName by remember{
                mutableStateOf("")
            }
            var categoryDescription by remember{
                mutableStateOf("")
            }

            TextField(
                value = categoryName,
                onValueChange = { categoryName = it},
                label = {
                    Text("Category Name")
                },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.padding(vertical = 16.dp))

            TextField(
                value = categoryDescription,
                onValueChange = { categoryDescription = it},
                label = {
                    Text("Description")
                },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.padding(vertical = 16.dp))

            Button(
                onClick = { }
            ) {
                Text("Add")
            }
        }

    }
}
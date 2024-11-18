package com.example.librarymanagementsystem.ui.book

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
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
fun AddBook(){
    Column(modifier = Modifier) {
        LibraryManagementAppBar("Add Book")

        Column(modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 8.dp)
        ){
            var bookName by remember{
                mutableStateOf("")
            }
            var bookAuthor by remember{
                mutableStateOf("")
            }
            var bookDescription by remember{
                mutableStateOf("")
            }
            var bookCategory by remember{
                mutableStateOf("")
            }
            var isDropdownExpanded by remember { mutableStateOf(false) }

            val categories = listOf("Fiction", "Non-Fiction", "Science Fiction", "Biography", "Fantasy")



            TextField(
                value = bookName,
                onValueChange = { bookName = it},
                label = {
                    Text("Title")
                },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.padding(vertical = 16.dp))

            TextField(
                value = bookAuthor,
                onValueChange = { bookAuthor = it},
                label = {
                    Text("Author")
                },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.padding(vertical = 16.dp))

            ExposedDropdownMenuBox(
                expanded = isDropdownExpanded,
                onExpandedChange = { isDropdownExpanded = !isDropdownExpanded }
            ) {
                TextField(
                    value = bookCategory,
                    onValueChange = {},
                    readOnly = true,
                    label = { Text("Category") },
                    trailingIcon = {
                        ExposedDropdownMenuDefaults.TrailingIcon(expanded = isDropdownExpanded)
                    },
                    modifier = Modifier
                        .menuAnchor() // Needed for proper positioning of the dropdown
                        .fillMaxWidth()
                )

                ExposedDropdownMenu(
                    expanded = isDropdownExpanded,
                    onDismissRequest = { isDropdownExpanded = false }
                ) {
                    categories.forEach { category ->
                        DropdownMenuItem(
                            text = { Text(category) },
                            onClick = {
                                bookCategory = category
                                isDropdownExpanded = false
                            }
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.padding(vertical = 16.dp))

            TextField(
                value = bookDescription,
                onValueChange = { bookDescription = it},
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
package com.example.librarymanagementsystem

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalOf
import com.example.librarymanagementsystem.ui.BookCategoryScreen

@Composable
fun LibraryManagementAppBar(){
    Column(
        modifier = Modifier
    ) {
        Row() {
            Text(text = "Back")
        }
    }
}

@Composable
fun LibraryManagementApp(){
    LibraryManagementAppBar()
    BookCategoryScreen()
}
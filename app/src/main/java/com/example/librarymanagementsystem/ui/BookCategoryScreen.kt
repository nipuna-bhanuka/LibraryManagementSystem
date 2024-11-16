package com.example.librarymanagementsystem.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BookCategoryScreen(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 4.dp, vertical = 8.dp)
    ) {
        BookCategoryCard(title = "Novels", noOfBooks = 20)
        BookCategoryCard(title = "ShortStories", noOfBooks = 10)
        BookCategoryCard(title = "Novels", noOfBooks = 20)
        BookCategoryCard(title = "ShortStories", noOfBooks = 10)
    }
}

@Composable
fun BookCategoryCard(title:String, noOfBooks: Int){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(128.dp)
            .padding(16.dp)
            .background(MaterialTheme.colorScheme.primary),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Column(
            modifier = Modifier.padding(4.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = title,
                fontSize = 32.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
                )

            Text(
                text = "No of Books : $noOfBooks",
                fontSize = 20.sp,
                color = Color.White
                )
        }
    }
}
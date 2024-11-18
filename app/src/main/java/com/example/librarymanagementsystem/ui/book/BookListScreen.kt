package com.example.librarymanagementsystem.ui.book

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.librarymanagementsystem.R
import com.example.librarymanagementsystem.ui.navigation.Routes

@Composable
fun BookListScreen(navController: NavController){
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        BookCard(
            title = "Harry Potter1",
            author = "Auther name",
            availability = true,
            onClick = {}
        )
        BookCard(
            title = "Harry Potter2",
            author = "Auther name",
            availability = true,
            onClick = {}
        )
        BookCard(
            title = "Harry Potter3",
            author = "Auther name",
            availability = false,
            onClick = {}
        )

        Spacer(modifier = Modifier.padding(vertical = 16.dp))

        Button(
            onClick = {navController.navigate(Routes.addbook) }
        ) {
            Text("Add")
        }
    }
}

@Composable
fun BookCard(
    title :String,
    author : String,
    availability: Boolean,
    onClick : () -> Unit
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .padding(8.dp)
            .border(
                width = 2.dp,
                color = Color.Gray,
                shape = RoundedCornerShape(8.dp)
            )
            .clickable { onClick() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(R.drawable.harrypotter),
            contentDescription = null,
            modifier = Modifier
                .size(100.dp)
                .padding(end = 8.dp)
        )

        Column() {
            Text(
                text = title
            )
            Text(
                text = author
            )
        }
    }
}
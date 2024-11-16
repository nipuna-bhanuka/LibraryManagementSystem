package com.example.librarymanagementsystem.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.librarymanagementsystem.R

@Composable
fun BookListScreen(){
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        BookCard(title = "Harry Potter1", author = "Auther name", availability = true)
        BookCard(title = "Harry Potter2", author = "Auther name", availability = true)
        BookCard(title = "Harry Potter3", author = "Auther name", availability = false)
    }
}

@Composable
fun BookCard(title :String, author : String, availability: Boolean){
    Row(

    ) {
        Image(
            painter = painterResource(R.drawable.harryPotter),
            contentDescription = null
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
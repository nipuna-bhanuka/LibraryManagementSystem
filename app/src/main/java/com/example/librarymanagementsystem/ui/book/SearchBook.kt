package com.example.librarymanagementsystem.ui.book

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp

@Composable
fun SearchBook(){
    Column(modifier = Modifier) {
        BookSearch()
    }
}


@Composable
fun BookSearch(){
    val keyBoardController = LocalSoftwareKeyboardController.current

    Row(
        modifier = Modifier
            .padding(horizontal = 8.dp)
            .padding(top = 128.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        OutlinedTextField(
            modifier = Modifier.weight(1f),
            value = "",
            onValueChange = {},
            label = {
                Text(text = "Search book")
            }
        )
        IconButton(onClick = {
            keyBoardController?.hide()
        }
        ) {
            Icon(imageVector = Icons.Default.Search,
                contentDescription = "Search Book"
            )
        }
    }
}
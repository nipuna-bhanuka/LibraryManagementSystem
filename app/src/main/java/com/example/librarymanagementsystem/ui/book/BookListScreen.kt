package com.example.librarymanagementsystem.ui.book

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.librarymanagementsystem.LibraryManagementAppBar
import com.example.librarymanagementsystem.R
import com.example.librarymanagementsystem.data.Book.Book
import com.example.librarymanagementsystem.ui.AppViewModelProvider
import com.example.librarymanagementsystem.ui.navigation.Routes

@Composable
fun BookListScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: BookListViewModel = viewModel(factory = AppViewModelProvider.Factory)
    ) {

    val bookUiState by viewModel.bookUiState.collectAsState()

    Scaffold(
        topBar = { LibraryManagementAppBar("Select Book") },

        floatingActionButton = {
            FloatingActionButton(
                onClick = {navController.navigate(Routes.addbook)},
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier
                    .padding(
                        end = WindowInsets.safeDrawing.asPaddingValues()
                            .calculateEndPadding(LocalLayoutDirection.current)
                    )
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add book"
                )
            }
        }
    ) {
        innerPadding ->
        BookViewBody(
            bookList = bookUiState.bookList,
            onBookClick = {navController.navigate(Routes.booklist)},
            modifier = Modifier.fillMaxSize(),
            contentPadding = innerPadding
        )
    }
}



@Composable
private fun BookViewBody(
    bookList: List<Book>,
    onBookClick: (Int) -> Unit,
    modifier: Modifier= Modifier,
    contentPadding : PaddingValues = PaddingValues(0.dp)
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        if(bookList.isEmpty()){
            Text(
                text = "No books available",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleLarge,
                modifier = modifier.padding(vertical = 128.dp)
                )
        }else {
            BookList(
                bookList = bookList,
                onBookClick = {onBookClick(it.id)},
                contentPadding = contentPadding,
                modifier = Modifier.padding(horizontal = 8.dp)
            )
        }
    }
}

@Composable
private fun BookList(
    bookList: List<Book>,
    onBookClick: (Book) -> Unit,
    contentPadding: PaddingValues,
    modifier: Modifier = Modifier
){
    LazyColumn(
        modifier = modifier,
        contentPadding = contentPadding
    ) {
        items(items = bookList, key = {it.id}){ book ->
            BookCard(
                book = book,
                modifier = Modifier
                    .padding()
                    .clickable { onBookClick(book) }
            )
        }
    }
}

@Composable
private fun BookCard(
    book: Book,
    modifier: Modifier= Modifier
){
    Card(
        modifier = modifier.padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column{
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .padding(8.dp)
                    .border(
                        width = 2.dp,
                        color = Color.Gray,
                        shape = RoundedCornerShape(8.dp)
                    ),
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
                        text = book.title
                    )
                    Text(
                        text = book.author
                    )
                }
            }
        }
    }
}


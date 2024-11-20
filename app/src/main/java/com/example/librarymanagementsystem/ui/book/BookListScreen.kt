package com.example.librarymanagementsystem.ui.book

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
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
    categoryId: Int?,
    categoryName: String?,
    modifier: Modifier = Modifier,
    viewModel: BookListViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    val bookUiState by viewModel.bookUiState.collectAsState()
    val (searchQuery, setSearchQuery) = remember { mutableStateOf("") }

    val filteredBooks = if (searchQuery.isEmpty()) {
        bookUiState.bookList
    } else {
        bookUiState.bookList.filter {
            it.title.contains(searchQuery, ignoreCase = true) ||
                    it.author.contains(searchQuery, ignoreCase = true)
        }
    }

    Scaffold(
        topBar = { LibraryManagementAppBar(categoryName ?: "") },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate(
                        Routes.addbook + "/${categoryId ?: 0}/${categoryName ?: ""}"
                    )
                },
                contentColor = Color.White,
                containerColor = Color.Magenta,
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier.padding(
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
    ) { innerPadding ->
        BookViewBody(
            bookList = filteredBooks,
            onBookClick = { book -> navController.navigate(Routes.bookdetail + "/${book.id}") },
            searchQuery = searchQuery,
            onSearchQueryChanged = setSearchQuery,
            modifier = Modifier.fillMaxSize(),
            contentPadding = innerPadding
        )
    }
}

@Composable
private fun BookViewBody(
    bookList: List<Book>,
    onBookClick: (Book) -> Unit,
    searchQuery: String,
    onSearchQueryChanged: (String) -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {

        if (bookList.isEmpty()) {
            Text(
                text = "No books available",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleLarge,
                modifier = modifier.padding(vertical = 128.dp)
            )
        } else {
            SearchBar(
                searchQuery = searchQuery,
                onSearchQueryChanged = onSearchQueryChanged,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .padding(top = 112.dp)
            )

            BookList(
                bookList = bookList,
                onBookClick = { onBookClick(it) },
                contentPadding = contentPadding,
                modifier = Modifier.padding(horizontal = 8.dp)
            )
        }
    }
}

@Composable
fun SearchBar(
    searchQuery: String,
    onSearchQueryChanged: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    TextField(
        value = searchQuery,
        onValueChange = onSearchQueryChanged,
        placeholder = { Text("Search books...") },
        singleLine = true,
        modifier = modifier
            .background(
                color = Color(0xFFF7F9FC),
                shape = RoundedCornerShape(8.dp)
            )
            .padding(vertical = 8.dp)
    )
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
       // contentPadding = contentPadding
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
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
                .padding(4.dp)
                .background(
                    color = Color(0xFFF7F9FC),
                    shape = RoundedCornerShape(8.dp)
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(R.drawable.harrypotter),
                contentDescription = "Book Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(100.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .padding(8.dp)
            )

            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(start = 8.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = book.title,
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "by ${book.author}",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Gray,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }

}


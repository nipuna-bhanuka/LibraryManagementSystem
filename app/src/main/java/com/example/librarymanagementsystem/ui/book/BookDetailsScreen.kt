package com.example.librarymanagementsystem.ui.book

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.librarymanagementsystem.LibraryManagementAppBar
import com.example.librarymanagementsystem.R
import com.example.librarymanagementsystem.data.Book.Book
import com.example.librarymanagementsystem.ui.AppViewModelProvider
import kotlinx.coroutines.launch

@Composable
fun BookDetailsScreen(
    navController: NavController,
    bookId: Int?,
    viewModel: BookDetailsViewModel = viewModel(factory = AppViewModelProvider.Factory),
) {

    val bookUiState by viewModel.bookUiState.collectAsState()
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        topBar = { LibraryManagementAppBar("Book Details") }
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            BookDetailsContent(
                bookDetails = bookUiState.bookDetails,
                onEditClick = {
                    navController.navigate("edit_book/$bookId")
                },
                onDeleteClick = {
                    coroutineScope.launch {
                        viewModel.deleteBook(bookUiState.bookDetails?: return@launch)
                        navController.popBackStack()
                    }

                }
            )
        }
    }
}

@Composable
fun BookDetailsContent(
    bookDetails: Book?,
    onEditClick: () -> Unit,
    onDeleteClick: () -> Unit
) {

    var showDeleteDialog by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Image(
            painter = painterResource(id = R.drawable.harrypotter),
            contentDescription = "Book Image",
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .height(200.dp)
                .background(Color.Gray, RoundedCornerShape(8.dp))
        )

        Spacer(modifier = Modifier.height(16.dp))

        if (bookDetails != null) {
            Text(
                text = bookDetails.title,
                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        if (bookDetails != null) {
            Text(
                text = "Author: ${bookDetails.author}",
                style = MaterialTheme.typography.bodyMedium.copy(fontSize = 16.sp),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Description",
            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.SemiBold),
            modifier = Modifier.padding(bottom = 8.dp)
        )
        if (bookDetails != null) {
            Text(
                text = bookDetails.description,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Button(
                onClick = onEditClick,
                colors = ButtonDefaults.buttonColors(containerColor = Color.Magenta)
            ) {
                Text("Edit Details")
            }

            Button(
                onClick = { showDeleteDialog = true },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
            ) {
                Text("Delete Book")
            }
            if(showDeleteDialog){
                DeleteConfirmationDialog(
                    onDeleteConfirm = {
                        showDeleteDialog = false // Close the dialog
                        onDeleteClick() // Perform delete action
                    },
                    onDeleteCancel = {
                        showDeleteDialog = false // Close the dialog
                    }
                )
            }
        }
    }
}

@Composable
private fun DeleteConfirmationDialog(
    onDeleteConfirm: () -> Unit, onDeleteCancel: () -> Unit, modifier: Modifier = Modifier
) {
    AlertDialog(onDismissRequest = { },
        title = { Text("Attention") },
        text = {Text("Are you sure you want to delete") },
        modifier = modifier,
        dismissButton = {
            TextButton(onClick = onDeleteCancel) {
                Text(text = "No")
            }
        },
        confirmButton = {
            TextButton(onClick = onDeleteConfirm) {
                Text(text = "Yes")
            }
        })
}

package com.example.librarymanagementsystem.ui.book

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
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

@Composable
fun BookDetailsScreen(
    navController: NavController,
    bookId: Int?,
    viewModel: BookDetailsViewModel = viewModel(factory = AppViewModelProvider.Factory),
) {
//    val bookDetails : Book = ""
//
//    Scaffold(
//        topBar = { LibraryManagementAppBar("Book Details") }
//
//    ) { paddingValues ->
//        Box(modifier = Modifier.padding(paddingValues)) {
//            if (bookDetails == null) {
//                CircularProgressIndicator(
//                    modifier = Modifier.align(Alignment.Center),
//                    color = Color.Magenta
//                )
//            } else {
//                BookDetailsContent(
//                    bookDetails = bookDetails,
//                    onEditClick = {
//                        navController.navigate("edit_book/$bookId")
//                    },
//                    onDeleteClick = {
//                        viewModel.deleteBook(bookId)
//                        navController.popBackStack()
//                    }
//                )
//            }
//        }
//    }
}

//@Composable
//fun BookDetailsContent(
//    bookDetails: Book?,
//    onEditClick: () -> Unit,
//    onDeleteClick: () -> Unit
//) {
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(16.dp)
//    ) {
//
//        Image(
//            painter = painterResource(id = R.drawable.harrypotter),
//            contentDescription = "Book Image",
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(200.dp)
//                .background(Color.Gray, RoundedCornerShape(8.dp))
//        )
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        Text(
//            text = bookDetails.title,
//            style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
//            modifier = Modifier.fillMaxWidth(),
//            textAlign = TextAlign.Center
//        )
//
//        Spacer(modifier = Modifier.height(8.dp))
//
//        Text(
//            text = "Author: ${bookDetails.author}",
//            style = MaterialTheme.typography.bodyMedium.copy(fontSize = 16.sp),
//            modifier = Modifier.fillMaxWidth(),
//            textAlign = TextAlign.Center
//        )
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        Text(
//            text = "Description",
//            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.SemiBold),
//            modifier = Modifier.padding(bottom = 8.dp)
//        )
//        Text(
//            text = bookDetails.description,
//            style = MaterialTheme.typography.bodyMedium,
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(bottom = 16.dp)
//        )
//
//        Spacer(modifier = Modifier.weight(1f))
//
//        Row(
//            modifier = Modifier.fillMaxWidth(),
//            horizontalArrangement = Arrangement.SpaceBetween
//        ) {
//
//            Button(
//                onClick = onEditClick,
//                colors = ButtonDefaults.buttonColors(containerColor = Color.Magenta)
//            ) {
//                Text("Edit Details")
//            }
//
//            Button(
//                onClick = onDeleteClick,
//                colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
//            ) {
//                Text("Delete Book")
//            }
//        }
//    }
//}

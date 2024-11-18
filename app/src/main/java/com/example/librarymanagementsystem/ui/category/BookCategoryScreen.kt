package com.example.librarymanagementsystem.ui.category

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.librarymanagementsystem.ui.navigation.Routes

@Composable
fun BookCategoryScreen(navController: NavController){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 4.dp, vertical = 8.dp)
    ) {
        BookCategoryCard(
            title = "Novels",
            noOfBooks = 20,
            onClick = {
                navController.navigate(Routes.booklist)
            })
        BookCategoryCard(
            title = "ShortStories",
            noOfBooks = 10,
            onClick = {
                navController.navigate(Routes.booklist)
            })
        BookCategoryCard(
            title = "Comics",
            noOfBooks = 20,
            onClick = {
                navController.navigate(Routes.booklist)
            })
        BookCategoryCard(
            title = "ShortStories-2",
            noOfBooks = 10,
            onClick = {
                navController.navigate(Routes.booklist)
            }
        )

        Spacer(modifier = Modifier.padding(vertical = 16.dp))

        Button(
            onClick = {
                navController.navigate(Routes.addcategory)
            }
        ) {
            Text("Add")
        }
    }
}

@Composable
fun BookCategoryCard(
    title:String,
    noOfBooks: Int,
    onClick: () -> Unit
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(128.dp)
            .padding(16.dp)
            .background(MaterialTheme.colorScheme.primary)
            .clickable { onClick() },
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
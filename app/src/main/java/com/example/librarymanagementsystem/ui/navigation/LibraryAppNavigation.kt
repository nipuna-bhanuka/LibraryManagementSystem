package com.example.librarymanagementsystem.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.internal.composableLambda
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.librarymanagementsystem.ui.book.AddBook
import com.example.librarymanagementsystem.ui.book.BookListScreen
import com.example.librarymanagementsystem.ui.category.AddCategory
import com.example.librarymanagementsystem.ui.category.BookCategoryScreen

@Composable
fun LibraryAppNavigation(
    navController: NavHostController,
    modifier: Modifier = Modifier
){
    NavHost(
        navController = navController,
        startDestination = Routes.bookcategory,
        modifier = modifier
    ){
        composable(route = Routes.bookcategory){
            BookCategoryScreen(navController)
        }
        composable(route = Routes.addcategory){
            AddCategory()
        }
        composable(route = Routes.booklist){
            BookListScreen(navController)
        }
        composable(route = Routes.addbook){
            AddBook()
        }
    }
}
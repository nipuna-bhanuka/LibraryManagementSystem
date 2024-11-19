package com.example.librarymanagementsystem.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.librarymanagementsystem.ui.book.AddBook
import com.example.librarymanagementsystem.ui.book.BookDetails
import com.example.librarymanagementsystem.ui.book.BookDetailsScreen
import com.example.librarymanagementsystem.ui.book.BookListScreen
import com.example.librarymanagementsystem.ui.category.AddCategoryScreen
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
            AddCategoryScreen()
        }
        composable(
            route = Routes.booklist + "/{categoryId}/{categoryName}",
            arguments = listOf(
                navArgument("categoryId") { type = NavType.IntType },
                navArgument("categoryName") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val categoryId = backStackEntry.arguments?.getInt("categoryId")
            val categoryName = backStackEntry.arguments?.getString("categoryName")
            BookListScreen(navController = navController, categoryId = categoryId, categoryName = categoryName)
        }

        composable(
            route = Routes.addbook + "/{categoryId}/{categoryName}",
            arguments = listOf(
                navArgument("categoryId") { type = NavType.IntType },
                navArgument("categoryName") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val categoryId = backStackEntry.arguments?.getInt("categoryId")
            val categoryName = backStackEntry.arguments?.getString("categoryName")
            AddBook(navController, categoryId, categoryName)
        }

        composable(route = Routes.bookdetail + "/{bookId}"){
            val bookId = it.arguments?.getInt("bookId")
            BookDetailsScreen(navController= navController,bookId)
        }

    }
}
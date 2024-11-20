package com.example.librarymanagementsystem.ui.navigation

import androidx.compose.foundation.gestures.snapping.SnapPosition
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
import com.example.librarymanagementsystem.ui.book.EditBookScreen
import com.example.librarymanagementsystem.ui.category.AddCategoryScreen
import com.example.librarymanagementsystem.ui.category.BookCategoryScreen
import com.example.librarymanagementsystem.ui.home.StartScreen

@Composable
fun LibraryAppNavigation(
    navController: NavHostController,
    modifier: Modifier = Modifier
){
    NavHost(
        navController = navController,
        startDestination = Routes.home,
        modifier = modifier
    ){
        composable(route = Routes.home){
            StartScreen(navController)
        }
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

        composable(
            route = Routes.bookdetail + "/{bookId}",
            arguments = listOf(
                navArgument("bookId") { type = NavType.IntType }
            )
        ) { backStackEntry ->
            val bookId = backStackEntry.arguments?.getInt("bookId")
            BookDetailsScreen(navController = navController, bookId = bookId)
        }

//        composable(
//            route = Routes.editbook,
//            arguments = listOf(
//                navArgument("categoryId") { type = NavType.IntType },
//                navArgument("categoryName") { type = NavType.StringType },
//                navArgument("bookId") { type = NavType.IntType },
//                navArgument("bookTitle") { type = NavType.StringType },
//                navArgument("bookAuthor") { type = NavType.StringType },
//                navArgument("bookDescription") { type = NavType.StringType },
//                )
//            ) { backStackEntry ->
//                val categoryId = backStackEntry.arguments?.getInt("categoryId")
//                val categoryName = backStackEntry.arguments?.getString("categoryName")
//                val bookId = backStackEntry.arguments?.getInt("bookId")
//                val bookTitle = backStackEntry.arguments?.getString("bookTitle")
//                val bookAuthor = backStackEntry.arguments?.getString("bookAuthor")
//                val bookDescription = backStackEntry.arguments?.getString("bookDescription")
//            EditBookScreen(
//                categoryId = categoryId,
//                categoryNmae = categoryName,
//                bookId = bookId,
//                bookTitle = bookTitle,
//                bookAuthor = bookAuthor,
//                bookDescription = bookDescription,
//                navigateBack = { navController.popBackStack() },
//                onNavigateUp = { navController.navigateUp() }
//            )
//        )
    }
}
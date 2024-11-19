package com.example.librarymanagementsystem

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.librarymanagementsystem.ui.navigation.LibraryAppNavigation

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LibraryManagementAppBar(title : String){
    Column(
        modifier = Modifier
    ) {
        TopAppBar(
            title = {
                Text(title)
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color.Magenta,
                titleContentColor = Color.White,
                navigationIconContentColor = Color.White,
                actionIconContentColor = Color.White
            )
        )
    }
}

@Composable
fun LibraryManagementApp(navController: NavHostController = rememberNavController()){
    LibraryAppNavigation(navController = navController)
}
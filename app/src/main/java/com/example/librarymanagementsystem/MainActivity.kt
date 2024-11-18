package com.example.librarymanagementsystem

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.librarymanagementsystem.ui.theme.LibraryManagementSystemTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LibraryManagementSystemTheme {
                    LibraryManagementApp()
            }
        }
    }
}


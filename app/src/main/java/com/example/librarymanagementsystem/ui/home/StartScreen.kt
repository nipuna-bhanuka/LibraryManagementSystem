package com.example.librarymanagementsystem.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.librarymanagementsystem.ui.navigation.Routes

@Composable
fun StartScreen(
    navController: NavController,
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(com.example.librarymanagementsystem.R.drawable.books),
            contentDescription = "background Image",
            modifier = Modifier.matchParentSize().fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text ="Welcome",
                fontSize = 32.sp,
                color = Color.White)
            Spacer(modifier = Modifier.height(16.dp))
            Text("to",
                fontSize = 24.sp,
                color = Color.White)
            Spacer(modifier = Modifier.height(16.dp))
            Text("the",
                fontSize = 24.sp,
                color = Color.White)
            Spacer(modifier = Modifier.height(16.dp))
            Text("Library",
                fontSize = 32.sp,
                color = Color.White)

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { navController.navigate(Routes.bookcategory) },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Magenta,
                    contentColor = Color.White
                ),
                shape = MaterialTheme.shapes.small,
                modifier = Modifier.fillMaxWidth(0.6f)
            ) {
                Text("Continue ")
                Icon(
                    imageVector = Icons.Default.ArrowForward,
                    contentDescription = "Add category"
                )
            }
        }
    }
}

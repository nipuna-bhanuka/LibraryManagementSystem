package com.example.librarymanagementsystem.ui.category

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.librarymanagementsystem.LibraryManagementAppBar
import com.example.librarymanagementsystem.R
import com.example.librarymanagementsystem.data.Category.CategoryWithBookCount
import com.example.librarymanagementsystem.ui.AppViewModelProvider
import com.example.librarymanagementsystem.ui.navigation.Routes

@Composable
fun BookCategoryScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: BookCategoryViewModel = viewModel(factory = AppViewModelProvider.Factory)
){
    val categoryUiState by viewModel.categoryUiState.collectAsState()

    Scaffold(
        topBar = { LibraryManagementAppBar("Select Category") },

        floatingActionButton = {
            FloatingActionButton(
                onClick = {navController.navigate(Routes.addcategory)},
                contentColor = Color.White,
                containerColor = Color.Magenta,
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier
                    .padding(
                        end = WindowInsets.safeDrawing.asPaddingValues()
                            .calculateEndPadding(LocalLayoutDirection.current)
                    )
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add category"
                )
            }
        }
    ) {
        innerPadding ->
        CategoryViewBody(
            categoryList = categoryUiState.categoryList,
            onCategoryClick = { categoryId, categoryName ->
                navController.navigate(Routes.booklist + "/${categoryId}/${categoryName}")
            },
            modifier = Modifier.fillMaxSize(),
            contentPadding = innerPadding
        )
    }
}

@Composable
private fun CategoryViewBody(
    categoryList: List<CategoryWithBookCount>,
    onCategoryClick: (Int, String) -> Unit,
    modifier: Modifier= Modifier,
    contentPadding : PaddingValues = PaddingValues(0.dp)
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        if(categoryList.isEmpty()){
            Text(
                text = "No categories available",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleLarge,
                modifier = modifier.padding(vertical = 128.dp)
            )
        }else {
            CategoryList(
                categoryList = categoryList,
                onCategoryClick = {onCategoryClick(it.categoryId, it.categoryName)},
                contentPadding = contentPadding,
                modifier = Modifier.padding(horizontal = 8.dp)
            )
        }
    }
}

@Composable
private fun CategoryList(
    categoryList: List<CategoryWithBookCount>,
    onCategoryClick: (CategoryWithBookCount) -> Unit,
    contentPadding: PaddingValues,
    modifier: Modifier = Modifier
){
    LazyColumn(
        modifier = modifier,
        contentPadding = contentPadding
    ) {
        items(items = categoryList, key = {it.categoryId}){ category ->
            CategoryCard(
                category = category,
                modifier = Modifier
                    .padding()
                    .clickable { onCategoryClick(category) }
            )
        }
    }
}

@Composable
private fun CategoryCard(
    category: CategoryWithBookCount,
    modifier: Modifier= Modifier
){
    Card(
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Box(modifier = Modifier.height(160.dp)) {
            Image(
                painter = painterResource(R.drawable.background),
                contentDescription = "Category Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .alpha(0.2f)
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center // Center text vertically
            ) {
                Text(
                    text = category.categoryName,
                    fontSize = 32.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(8.dp)) // Add spacing between texts

                Text(
                    text = "No of Books: ${category.noOfBooks}",
                    fontSize = 20.sp,
                    color = Color.Gray,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }

}

package com.arminder.group2

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter


@Composable
fun HomeScreen(navController: NavController) {
    Column {
        TopAppBar(title = { Text("Home") })
        OutlinedTextField(value = "", onValueChange = {}, label = { Text("Search") })

        LazyColumn {
            items(productList) { product ->
                Card(modifier = Modifier
                    .fillMaxWidth()
                    .clickable { navController.navigate(Screen.ProductPreview.route) }) {
                    Row(modifier = Modifier.padding(16.dp)) {
                        Text(text = product.name, modifier = Modifier.weight(1f))
                        Text(text = "$${product.price}")
                        Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = null)
                    }
                }
            }
        }
    }
}

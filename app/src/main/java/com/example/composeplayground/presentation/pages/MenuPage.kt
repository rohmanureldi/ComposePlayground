package com.example.composeplayground.presentation.pages

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun MenuPage(
    navController: NavController,
    menuList: Map<String, String>
) {
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        LazyColumn(
            Modifier.align(Alignment.CenterHorizontally)
        ){
            items(menuList.keys.toList())
            { item ->
                Button(
                    onClick = {
                        navController.navigate(menuList[item]!!)
                    }
                ) {
                    Text(
                        text = item
                    )
                }
                Spacer(modifier = Modifier.padding(bottom = 12.dp))
            }
        }
    }

}
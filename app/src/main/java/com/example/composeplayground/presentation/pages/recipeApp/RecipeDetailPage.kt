package com.example.composeplayground.presentation.pages.recipeApp

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.composeplayground.domain.model.RecipeEntity
import com.example.composeplayground.presentation.MainViewModel

@Composable
fun RecipeDetailPage(
    recipe: RecipeEntity
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
            painter = rememberImagePainter(
                data = recipe.featured_image,
                builder = {
                    crossfade(true)
                }
            ),
            contentScale = ContentScale.Crop,
            contentDescription = recipe.title
        )

        Text(
            text = recipe.title,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, top = 16.dp),
            style = MaterialTheme.typography.h5
        )

        Spacer(modifier = Modifier.padding(vertical = 4.dp))
        Text(
            text = "Ingredients",
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, top = 8.dp, bottom = 8.dp),
            style = MaterialTheme.typography.subtitle1
        )

        LazyColumn(
            Modifier.padding(horizontal = 20.dp)
        ) {
            items(recipe.ingredients) { ingredient ->
                Row(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Canvas(
                        modifier = Modifier
                            .align(Alignment.CenterVertically),
                    ) {
                        drawCircle(
                            radius = 10f,
                            brush = SolidColor(Color.Black)
                        )
                    }
                    Text(
                        text = ingredient,
                        style = MaterialTheme.typography.subtitle2,
                        modifier = Modifier.padding(horizontal = 8.dp)
                    )
                }
            }
        }
    }
}
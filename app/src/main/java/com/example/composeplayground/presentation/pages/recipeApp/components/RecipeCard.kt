package com.example.composeplayground.presentation.pages.recipeApp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.R
import coil.compose.rememberImagePainter
import com.example.composeplayground.domain.model.RecipeEntity

@ExperimentalMaterialApi
@Composable
fun RecipeCard(
    recipe: RecipeEntity,
    onClick: () -> Unit
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp),
        shape = MaterialTheme.shapes.medium,
        onClick = { onClick() }
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),

            ) {
            Image(
                painter = rememberImagePainter(
                    data = recipe.featured_image,
                    builder = {
                        crossfade(true)
                    }
                ),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
            )

            Spacer(modifier = Modifier.padding(vertical = 4.dp))
            Text(
                text = recipe.title,
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(horizontal = 8.dp)
            )
            Text(
                text = recipe.description,
                style = MaterialTheme.typography.subtitle1,
                modifier = Modifier.padding(bottom = 4.dp, start = 8.dp, end = 8.dp)
            )
        }
    }
}
package com.example.composeplayground.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.composeplayground.R

@Preview
@Composable
fun EmptyListComponent() {
    Column(
        Modifier.fillMaxSize(),
        Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.empty),
            contentDescription = "Oops, the recipe you are searching is not found",
            modifier = Modifier.align(Alignment.CenterHorizontally),
            alpha = 0.5f
        )

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally),
            text = "Oops, the recipe you are searching is not found",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.subtitle1,
            color = Color.LightGray
        )
    }
}
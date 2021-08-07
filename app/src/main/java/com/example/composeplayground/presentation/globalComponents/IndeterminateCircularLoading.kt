package com.example.composeplayground.presentation.globalComponents

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun IndeterminateCircularLoading() {
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        CircularProgressIndicator(
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
            color = MaterialTheme.colors.primary
        )
    }
}
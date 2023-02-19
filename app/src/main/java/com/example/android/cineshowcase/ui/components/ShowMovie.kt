package com.example.android.cineshowcase.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.placeholder
import com.google.accompanist.placeholder.shimmer

@ExperimentalCoilApi
@Composable
fun ShowTheMovie(
    modifier: Modifier = Modifier,
    painter1: Painter,
    onItemClick: () -> Unit
) {
    val painter = rememberImagePainter(
        data = painter1
    )
    Box(modifier = modifier.clickable { onItemClick() }) {
        Image(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center)
                .placeholder(
                    visible = false,
                    color = Color.Gray,
                    highlight = PlaceholderHighlight.shimmer(highlightColor = Color.White)
                ),
            alignment = Alignment.Center,
            contentScale = ContentScale.Crop,
            painter = painter,
            contentDescription = null
        )
    }

}
package com.example.android.cineshowcase.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.android.cineshowcase.Buttonbar
import com.example.android.cineshowcase.ui.theme.DarkPrimaryColor
import com.example.android.cineshowcase.ui.theme.Gray
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.placeholder
import com.google.accompanist.placeholder.shimmer

@OptIn(ExperimentalPagerApi::class)
@Composable
fun Books(navController: NavController, books: List<Painter>){
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Buttonbar(navController = navController)
        TheBooks(navController = navController, books = books )
    }

}


@OptIn(ExperimentalPagerApi::class)
@Composable
fun TheBooks(navController: NavController, books: List<Painter>){
    val pagerState = rememberPagerState()

    HorizontalPager(
        count = books.size,
        state = pagerState,
        modifier = Modifier
            .fillMaxWidth()
            .height(360.dp)
            .placeholder(
                visible = false,
                color = Color.Gray,
                highlight = PlaceholderHighlight.shimmer(highlightColor = Color.White)
            ),
    ) {
            page ->
        Image(
            modifier = Modifier
                .fillMaxSize()
                .placeholder(
                    visible = false,
                    color = Color.Gray,
                    highlight = PlaceholderHighlight.shimmer(highlightColor = Color.White)
                ),
            alignment = Alignment.Center,
            contentScale = ContentScale.Crop,
            painter = books[page],
            contentDescription = null
        )
        //Text(text = "photo # $page")
    }
    HorizontalPagerIndicator(
        modifier = Modifier
            .padding(vertical = 4.dp)
            .fillMaxWidth(0.15f)
            .placeholder(
                visible = false,
                color = Color.Gray,
                highlight = PlaceholderHighlight.shimmer(highlightColor = Color.White)
            ),
        pagerState = pagerState,
        indicatorHeight = 6.dp,
        indicatorWidth = 6.dp,
        spacing = 6.dp,
        activeColor = DarkPrimaryColor,
        inactiveColor = Gray
    )
}
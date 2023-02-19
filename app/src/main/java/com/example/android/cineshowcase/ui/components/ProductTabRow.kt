package com.example.android.cineshowcase.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.example.android.cineshowcase.ProductDestination

@Composable
fun ProductTabRow(
    allScreens: List<ProductDestination>,
    onTabSelected: (ProductDestination) -> Unit,
    currentScreen: ProductDestination
){
    Surface(
        androidx.compose.ui.Modifier
            .height(TabHeight)
            .fillMaxWidth()
    ) {
        Row(Modifier.selectableGroup()) {
            allScreens.forEach { screen ->
                ProductTab(
                    text = screen.text,
                    icon = screen.icon,
                    onSelected = { onTabSelected(screen) },
                    selected = currentScreen == screen
                )
            }
        }
    }
}

@Composable
fun ProductTab(
    text: String,
    icon: ImageVector,
    onSelected: () -> Unit,
    selected: Boolean
){

}

private val TabHeight = 56.dp

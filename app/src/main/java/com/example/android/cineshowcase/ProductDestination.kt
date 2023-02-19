package com.example.android.cineshowcase

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.List
import androidx.compose.ui.graphics.vector.ImageVector

interface ProductDestination {
 val icon: ImageVector
 val text: String
}

object Boooks: ProductDestination {
    override val icon = Icons.Filled.Face
    override val text = "Books"
}

object Fiilms: ProductDestination {
    override val icon = Icons.Filled.List
    override val text = "Films"
}


val NavigationMenuItems = listOf(Boooks,Fiilms)
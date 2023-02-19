package com.example.android.cineshowcase

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.android.cineshowcase.ui.components.Books
import com.example.android.cineshowcase.ui.components.Movies
import com.example.android.cineshowcase.ui.components.ProductTabRow
import com.example.android.cineshowcase.ui.theme.CineShowcaseTheme
import com.google.accompanist.pager.ExperimentalPagerApi

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //val systemUiController = rememberSystemUiController()
            CineShowcaseTheme() {
                Surface() {
                    NavigationScreen()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class, ExperimentalPagerApi::class)
@Composable
fun NavigationScreen (){
    val navController = rememberNavController()
    val photos = listOf(
        painterResource(com.example.android.cineshowcase.R.drawable.ariel),
        painterResource(com.example.android.cineshowcase.R.drawable.carlos),
        painterResource(com.example.android.cineshowcase.R.drawable.gato),
        painterResource(com.example.android.cineshowcase.R.drawable.c2)
    )
    val books = listOf(
        painterResource(com.example.android.cineshowcase.R.drawable.m1)
    )
    var currentScreen: ProductDestination by remember { mutableStateOf(Boooks) }

    Scaffold(
        bottomBar = {
            ProductTabRow(allScreens = NavigationMenuItems, onTabSelected = { screen -> currentScreen = screen } , currentScreen = currentScreen)
        }
    ) {
            contentPadding -> Box(modifier = Modifier.padding(contentPadding))
        NavHost(navController = navController, startDestination = "Screen1") {
            composable("Screen1") {
                //Screen1(navController)
                Movies(navController, photos)
            }
            composable("Screen2") {
                //Screen2(navController = navController)
                Books(navController, books)
            }
        }
    }

}

@Composable
fun Screen1(navController: NavController){
    Column() {
        Buttonbar(navController = navController)
        Text(text = "Tabla del 2")
        for (x in 1..10) {
            Text("2 * $x = ${x * 2}")
        }
    }
}

@Composable
fun Screen2(navController: NavController) {
    Column() {
        Buttonbar(navController = navController)
        Text(text = "Tabla del 5")
        for (x in 1..10) {
            Text("5 * $x = ${x * 5}")
        }
    }

}

@Composable
fun Screen3(navController: NavController) {
    Column() {
        Buttonbar(navController = navController)
        Text(text = "Tabla del 10")
        for (x in 1..10) {
            Text("10 * $x = ${x * 10}")
        }
    }

}

@Composable
fun Buttonbar(navController: NavController) {
    Row(horizontalArrangement = Arrangement.SpaceAround,modifier= Modifier
        .fillMaxWidth()
        .padding(10.dp)) {
        Button(onClick = {
            navController.navigate("screen1")
        }) {
            Text("Films")
        }
        Button(onClick = {
            navController.navigate("screen2")
        }) {
            Text("Books")
        }
        Button(onClick = {
            navController.navigate("screen3")
        }) {
            Text("Other")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CineShowcaseTheme {
        NavigationScreen ()
    }
}
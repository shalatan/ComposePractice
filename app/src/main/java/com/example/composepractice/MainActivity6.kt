package com.example.composepractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.composepractice.ui.theme.ComposePracticeTheme
import kotlin.random.Random

// State Demo

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePracticeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    StateDemo(Modifier.fillMaxSize())
                }
            }
        }
    }
}

@Composable
fun StateDemo(modifier: Modifier = Modifier) {
    val color = remember { mutableStateOf(Color.Yellow) }

    Box(
        modifier = modifier
            .background(color.value)
            .clickable {
                color.value = Color(
                    Random.nextFloat(),
                    Random.nextFloat(),
                    Random.nextFloat(),
                    1f
                )
            }
    )
}

//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    ComposePracticeTheme {
//        StateDemo(Modifier.fillMaxSize())
//    }
//}
package com.example.composepractice.philipp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import com.example.composepractice.ui.theme.ComposePracticeTheme

// ConstraintLayout

class MainActivity9 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePracticeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ConstraintDemo()
                }
            }
        }
    }
}

@Composable
fun ConstraintDemo(modifier: Modifier = Modifier) {
    val constraints = ConstraintSet {
        val greenBox = createRefFor("greenbox")
        val redBox = createRefFor("redbox")
        val guideline = createGuidelineFromTop(0.4f)

        constrain(greenBox) {
            top.linkTo(guideline)
            start.linkTo(parent.start)
            width = Dimension.value(50.dp)
            height = Dimension.value(50.dp)
        }
        constrain(redBox) {
            top.linkTo(greenBox.bottom)
            start.linkTo(greenBox.end)
            end.linkTo(parent.end)
//            to fill the gap completely
//            width = Dimension.fillToConstraints
            width = Dimension.value(50.dp)
            height = Dimension.value(50.dp)
        }
        createHorizontalChain(greenBox, redBox, chainStyle = ChainStyle.Spread)
    }
    ConstraintLayout(constraints, modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .background(Color.Green)
                .layoutId("greenbox")
        )
        Box(
            modifier = Modifier
                .background(Color.Red)
                .layoutId("redbox")
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview9() {
    ComposePracticeTheme {
        ConstraintDemo()
    }
}
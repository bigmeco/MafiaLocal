package com.bigmeco.mafialocal

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.ui.core.Modifier
import androidx.ui.core.setContent
import androidx.ui.foundation.Canvas
import androidx.ui.foundation.Image
import androidx.ui.foundation.Text
import androidx.ui.graphics.Color
import androidx.ui.graphics.drawscope.rotate
import androidx.ui.layout.preferredSize
import androidx.ui.material.MaterialTheme
import androidx.ui.res.colorResource
import androidx.ui.res.imageResource
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Host()
            }
        }
    }
}

@Composable
fun Host() {

     Text(text = "Пользователь")
}



@Preview
@Composable
fun DefaultPreview() {
    MaterialTheme {
        Host()
    }
}
@Composable
fun Rotate() {
    Canvas(modifier = Modifier.preferredSize(200.dp)) {
        rotate(45F) {
            drawRect(color = Color(255, 138, 128))
        }
    }
}
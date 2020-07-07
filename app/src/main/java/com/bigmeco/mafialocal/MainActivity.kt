package com.bigmeco.mafialocal

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.core.graphics.rotationMatrix
import androidx.ui.core.Modifier
import androidx.ui.core.drawLayer
import androidx.ui.core.setContent
import androidx.ui.foundation.Canvas
import androidx.ui.foundation.Image
import androidx.ui.foundation.Text
import androidx.ui.graphics.Color
import androidx.ui.graphics.drawscope.rotate
import androidx.ui.graphics.vectormath.rotation
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
     Text(text = "Пользователь",modifier =
     Modifier.drawLayer(rotationZ =
     320f))
}



@Preview
@Composable
fun DefaultPreview() {
    MaterialTheme {
        Host()
    }
}


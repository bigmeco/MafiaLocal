package com.bigmeco.mafialocal

import android.content.Intent
import android.os.Bundle
import androidx.animation.FastOutLinearInEasing
import androidx.animation.FloatPropKey
import androidx.animation.Infinite
import androidx.animation.transitionDefinition
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.ui.animation.Transition
import androidx.ui.core.ContentScale
import androidx.ui.core.Modifier
import androidx.ui.core.setContent
import androidx.ui.core.tag
import androidx.ui.foundation.*
import androidx.ui.foundation.shape.corner.CircleShape
import androidx.ui.graphics.Color
import androidx.ui.graphics.drawscope.rotate
import androidx.ui.layout.fillMaxSize
import androidx.ui.layout.preferredSize
import androidx.ui.material.Card
import androidx.ui.material.MaterialTheme
import androidx.ui.res.imageResource
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp

class SplashActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Box(modifier = Modifier.fillMaxSize(),
                    gravity = ContentGravity.Center,
                    children = {
                        Logo()
                    })
            }
        }
        startActivity(Intent(this, MainActivity::class.java))
    }


    @Composable
    fun Logo() {
        Card(
            modifier = Modifier.preferredSize(124.dp).tag("circle"),
            shape = CircleShape,
            elevation = 2.dp
        )
        {
            Image(
                imageResource(id = R.drawable.logo_test),
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }
    }


    @Preview
    @Composable
    fun DefaultPreview() {
        MaterialTheme {
            Logo()
        }
    }
}
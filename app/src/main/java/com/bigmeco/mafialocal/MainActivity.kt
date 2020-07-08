package com.bigmeco.mafialocal

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.annotation.FloatRange
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.core.graphics.rotationMatrix
import androidx.ui.core.*
import androidx.ui.foundation.*
import androidx.ui.foundation.shape.corner.CircleShape
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.*
import androidx.ui.graphics.drawscope.Stroke
import androidx.ui.graphics.drawscope.rotate
import androidx.ui.graphics.vectormath.rotation
import androidx.ui.layout.*
import androidx.ui.material.MaterialTheme
import androidx.ui.res.colorResource
import androidx.ui.res.imageResource
import androidx.ui.res.vectorResource
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.TextUnit
import androidx.ui.unit.dp
import kotlinx.coroutines.selects.select

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

    val tt = ScrollerPosition()
    Stack(modifier = Modifier.drawBackground(color = Color.Yellow)) {


        HorizontalScroller(
            isScrollable = false,
            scrollerPosition = tt,
            modifier = Modifier.wrapContentWidth(Alignment.CenterHorizontally)
        ) {
            Column(
                horizontalGravity = Alignment.CenterHorizontally,

                modifier = Modifier.drawLayer(rotationZ = 320f)
            ) {
                Box(
                    gravity = Alignment.BottomCenter,
                    modifier = Modifier.fillMaxSize().plus(Modifier.weight(1f)).plus(
                        Modifier.drawBackground(color = Color.Blue)
                    ).plus(Modifier.padding(horizontal = 1000.dp))
                        .plus(Modifier.clickable(onClick = {
                        }))
                ) {

                    Text(
                        text = "Ведущий",
                        fontSize = TextUnit(28),
                        modifier = Modifier.padding(46.dp)
                    )
                }

                Box(
                    gravity = Alignment.TopCenter,
                    modifier = Modifier.fillMaxSize().plus(Modifier.weight(1f)).plus(
                        Modifier.drawBackground(color = Color.Yellow)
                    ).plus(Modifier.padding(horizontal = 1000.dp))
                        .plus(Modifier.clickable(onClick = {
                        }))
                ) {
                    Text(
                        text = "Игрок", fontSize = TextUnit(28),
                        modifier = Modifier.padding(46.dp)
                    )
                }
            }

        }
        Box(
            modifier = Modifier.offset((-80).dp, (-50).dp)
                .plus(Modifier.drawLayer(rotationZ = 320f))
                .plus(Modifier.clickable(onClick = {
                }))
        ) {
            Image(
                vectorResource(id = R.drawable.user), contentScale = ContentScale.Crop,
                modifier = Modifier.drawShadow(15.dp)
                    .plus(Modifier.drawBackground(Color.Green))
                    .plus(Modifier.drawLayer(rotationZ = 40f))
                    .plus(
                        Modifier.padding(
                            top = 80.dp,
                            start = 100.dp,
                            end = 120.dp,
                            bottom = 2.dp
                        )
                    )
                    .plus(Modifier.preferredSize(48.dp))


            )
            tt.scrollTo((tt.maxPosition / 2.0).toFloat())
        }
    }


}


@Preview
@Composable
fun DefaultPreview() {
    MaterialTheme {
        Host()
    }
}
//
//Stack(  modifier = Modifier.plus(Modifier.drawLayer(rotationZ = 320f))) {
//    Column(modifier =
//    Modifier.offset(y = 160.dp)) {
//        Box(
//
//            modifier = Modifier.fillMaxSize().plus(Modifier.weight(1f)).plus(
//                Modifier.drawBackground(color = Color.Blue, style = Stroke(1200f))
//            ).plus(Modifier.drawBackground(color = Color.Blue))
//        )
//        Spacer(Modifier.preferredHeight(100.dp))
//        Box(
//            modifier = Modifier.fillMaxSize().plus(Modifier.weight(1f)).plus(
//                Modifier.drawBackground(color = Color.Yellow, style = Stroke(1200f))
//            ).plus(Modifier.drawBackground(color = Color.Yellow))
//        )
//    }
//    Column(
//    ) {
//        Text(
//            text = "Ведущий", modifier = Modifier.fillMaxSize().plus(Modifier.weight(1f))
//        )
//
//        Text(
//            text = "Игрок", modifier =
//            Modifier.fillMaxSize().plus(Modifier.weight(1f))
//        )
//    }
//
//}
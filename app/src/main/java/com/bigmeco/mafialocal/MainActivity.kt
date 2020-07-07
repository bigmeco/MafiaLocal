package com.bigmeco.mafialocal

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.annotation.FloatRange
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.core.graphics.rotationMatrix
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.core.drawLayer
import androidx.ui.core.setContent
import androidx.ui.foundation.*
import androidx.ui.graphics.Color
import androidx.ui.graphics.NativePathEffect
import androidx.ui.graphics.StrokeJoin
import androidx.ui.graphics.drawscope.Stroke
import androidx.ui.graphics.drawscope.rotate
import androidx.ui.graphics.vectormath.rotation
import androidx.ui.layout.*
import androidx.ui.material.MaterialTheme
import androidx.ui.res.colorResource
import androidx.ui.res.imageResource
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
    HorizontalScroller(isScrollable = true, scrollerPosition = ScrollerPosition(2000f)) {
        Column(
            horizontalGravity = Alignment.CenterHorizontally,

            modifier = Modifier.drawLayer(rotationZ = 320f)
        ) {
            Box(  paddingTop= 100.dp,
                modifier = Modifier.fillMaxSize().plus(Modifier.weight(1f)).plus(
                    Modifier.drawBackground(color = Color.Blue)
                ).plus(Modifier.padding(horizontal = 1000.dp))
            ) {
                Text(
                    text = "Ведущий", fontSize = TextUnit(28)
                )
            }

            Box(   paddingBottom = 100.dp,
                    modifier =
                Modifier.fillMaxSize().plus(Modifier.weight(1f)).plus(
                    Modifier.drawBackground(color = Color.Yellow)
                ).plus(Modifier.padding(horizontal = 1000.dp))
            ) {
                Text(
                    text = "Игрок", fontSize = TextUnit(28)
                )
            }
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
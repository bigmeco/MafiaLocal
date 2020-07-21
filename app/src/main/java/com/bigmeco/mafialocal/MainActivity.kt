package com.bigmeco.mafialocal

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.ui.core.*
import androidx.ui.foundation.*
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.material.MaterialTheme
import androidx.ui.res.vectorResource
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.TextUnit
import androidx.ui.unit.dp
import com.bigmeco.server.HostApi
import com.koushikdutta.async.AsyncNetworkSocket
import com.koushikdutta.async.AsyncServer
import com.koushikdutta.async.http.WebSocket
import com.koushikdutta.async.http.server.AsyncHttpServer
import java.net.NetworkInterface
import java.util.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Host()
            }
        }
        HostApi.httpServer
        val httpServer = AsyncHttpServer()
        httpServer.listen(AsyncServer.getDefault(), 8080)
        httpServer.websocket(
            "/live"
        ) { webSocket, request ->

            webSocket.setClosedCallback { ex ->
                Log.d("WebSocket", "start")

                try {
                    if (ex != null)
                        Log.e("WebSocket", "An error occurred", ex)
                } finally {
                }
            }
            webSocket.stringCallback = WebSocket.StringCallback { s ->
                if ("Hello Server" == s) {
                    webSocket.send("Welcome Client!")
                    Log.d("WebSocket", "sent")

                }
            }

        }
        getIPAddress{
            Log.d("WebSocket", it)


        }
    }

}


private fun getIPAddress(listener: (String) -> Unit) {
    try {
        val interfaces = Collections.list(NetworkInterface.getNetworkInterfaces())
        for (intf in interfaces) {
            val address = Collections.list(intf.inetAddresses)
            for (addr in address) {
                println(
                    "Display name: "
                            + addr.hostAddress
                )
                if (addr.hostAddress.subSequence(0, 3) == "192" || addr.hostAddress.subSequence(0, 3) == "172") {
                    listener.invoke(addr.hostAddress.toUpperCase())
                }

            }
        }
    } catch (ex: Exception) {
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
                        Modifier.drawBackground(color = Color.Red)
                    ).plus(Modifier.padding(horizontal = 1000.dp))
                        .plus(Modifier.clickable(onClick = {
                        }))
                ) {

                    Text(
                        text = "Ведущий",
                        fontSize = TextUnit(28),
                        modifier = Modifier.padding(horizontal = 320.dp,vertical = 46.dp)
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
                        modifier = Modifier.padding(horizontal = 320.dp,vertical = 46.dp)
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
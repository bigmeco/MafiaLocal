package com.bigmeco.mafialocal

sealed class Routing {
    object AlbumList : Routing()
    data class SplashScreen(val splash: SplashActivity) : Routing()
    data class MenuScreen(val menu: MainActivity) : Routing()
}
package com.hjames.entertainme.controllers

import android.util.Log
import com.beust.klaxon.Klaxon
import com.hjames.entertainme.models.KitsuResponse
import java.net.URL

class EntertainmentHubActivityController {
    private val tag = this.javaClass.name

    fun getAnimeList(): List<String> {
        val animeList = mutableListOf<String>()
        val result = URL("https://kitsu.io/api/edge/anime").readText()
        val response = Klaxon().parse<KitsuResponse>(result)
        Log.d(tag, response.toString())

        return animeList
    }
}
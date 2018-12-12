package com.hjames.entertainme.controllers

class EntertainmentHubActivityController {

    fun getAnimeList(): List<String> {
        val animeList = mutableListOf<String>()

        for (i in 1..25) {
            val animeName = "Anime $i"
            animeList.add(animeName)
        }

        return animeList
    }
}
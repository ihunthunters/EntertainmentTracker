package com.hjames.entertainme.models

class KitsuResponse(val data: Data)

class Data(val animeList: List<Anime>)

class Anime(val id: Int)
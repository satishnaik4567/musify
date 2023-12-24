package com.example.musify

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiInterface {
    @GET("search")
    @Headers("X-RapidAPI-Key : 6f1475f0d5mshdb3ef192dc4dddcp135b51jsn5d27ef37b244",
    "X-RapidAPI-Host : deezerdevs-deezer.p.rapidapi.com")

    fun getData(@Query("q") query:String) : Call<List<MyData>>
}

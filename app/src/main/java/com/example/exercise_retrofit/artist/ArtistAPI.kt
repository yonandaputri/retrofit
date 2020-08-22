package com.example.exercise_retrofit.artist

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ArtistAPI {

    @GET("artist/{id}")
    fun getArtistByID(@Path("id") id: String): Call<Artist>

    // karena dapet responnya artist lagi
    @POST("artist")
    fun createArtist(@Body artist: Artist): Call<Artist>
}
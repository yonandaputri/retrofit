package com.example.exercise_retrofit.artist

import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ArtistRepository(val artistAPI: ArtistAPI) {
    var artist: MutableLiveData<Artist> = MutableLiveData<Artist>()

    fun getArtist(id: String) {
        // Callback ngirim response
        artistAPI.getArtistByID(id).enqueue(object: Callback<Artist>{
            // kalau gagal kesini
            override fun onFailure(call: Call<Artist>, t: Throwable) {
                //println(t.localizedMessage)
                t.printStackTrace()
            }

            // kalau success kesini
            // dapat response
            override fun onResponse(call: Call<Artist>, response: Response<Artist>) {
                if (response.code() == 200) {
                    artist.value = response.body()
                }
                println("GAGAL ${response.code()}")
            }
        })
    }

    fun saveArtist(artist: Artist) {
        artistAPI.createArtist(artist).enqueue(object : Callback<Artist>{
            override fun onFailure(call: Call<Artist>, t: Throwable) {
                t.printStackTrace()
            }

            override fun onResponse(call: Call<Artist>, response: Response<Artist>) {
                println(response.isSuccessful)
            }
        })
    }
}
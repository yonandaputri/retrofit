package com.example.exercise_retrofit.artist

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.exercise_retrofit.config.RetrofitBuilder
import retrofit2.create
import javax.inject.Inject

class ArtistViewModel @Inject constructor(var artistRepository: ArtistRepository) : ViewModel() {

    // yang di observe oleh activity
    val artist: LiveData<Artist> = artistRepository.artist

    // function yang di trigger oleh activity
    fun getArtist(id: String) {
        artistRepository?.getArtist(id)
    }

    fun saveArtist(artist: Artist) {
        artistRepository?.saveArtist(artist)
    }
}
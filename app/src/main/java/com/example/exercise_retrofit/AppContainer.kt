package com.example.exercise_retrofit

import androidx.lifecycle.ViewModelProvider
import com.example.exercise_retrofit.artist.ArtistAPI
import com.example.exercise_retrofit.artist.ArtistRepository
import com.example.exercise_retrofit.artist.ArtistViewModel
import com.example.exercise_retrofit.config.RetrofitBuilder

// manual DI
class AppContainer {
    // yang boleh artistViewModel
    private val artistAPI: ArtistAPI = RetrofitBuilder.createRetrofit().create(ArtistAPI::class.java)
    private val artistRepository: ArtistRepository = ArtistRepository(artistAPI)
    //val artistViewModel: ArtistViewModelFactory = ArtistViewModelFactory(artistRepository)
    val artistViewModel: ArtistViewModel = ArtistViewModel(artistRepository)
}

// direkomendasikan untuk class yang tidak dibuat berulang
class ArtistViewModelFactory(val artistRepository: ArtistRepository): Factory<ArtistViewModel> {
    override fun create(): ArtistViewModel {
       return ArtistViewModel(artistRepository)
    }

}

// T nya generic atau bisa dipakai view model yang lainnya juga
interface Factory<T> {
    fun create(): T
}
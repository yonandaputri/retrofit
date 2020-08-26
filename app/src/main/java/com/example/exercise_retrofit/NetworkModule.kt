package com.example.exercise_retrofit

import com.example.exercise_retrofit.artist.ArtistAPI
import com.example.exercise_retrofit.config.RetrofitBuilder
import dagger.Module
import dagger.Provides

@Module
class NetworkModule {
    @Provides
    fun provideArtistAPI(): ArtistAPI {
        return RetrofitBuilder.createRetrofit().create(ArtistAPI::class.java)
    }
}
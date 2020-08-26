package com.example.exercise_retrofit

import com.example.exercise_retrofit.activity.MainActivity
import com.example.exercise_retrofit.screen.ArtistFragment
import com.example.exercise_retrofit.screen.CreateArtistFragment
import dagger.Component

@Component(modules = [NetworkModule::class])
interface ApplicationComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(artistFragment: ArtistFragment)
    fun inject(createArtistFragment: CreateArtistFragment)
}
package com.example.exercise_retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.example.exercise_retrofit.artist.ArtistViewModel
import kotlinx.android.synthetic.main.activity_main.*
import androidx.navigation.ui.NavigationUI
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment

class MainActivity : AppCompatActivity() {

    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navController = (nav_host_fragment_container as NavHostFragment).navController

        NavigationUI.setupWithNavController(bottom_navigation, navController)

        bottom_navigation.setOnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.showArtist ->{
                    println("SHOW ARTIST")
                    navController.navigate(R.id.action_to_artistFragment)
                    true
                }
                R.id.createArtist ->{
                    println("CREATE ARTIST")
                    navController.navigate(R.id.action_to_createArtisFragment)
                    true
                }
                else -> {
                    println("MASUK ELSE")
                    true
                }
            }
        }
    }
}

package com.example.exercise_retrofit.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.exercise_retrofit.artist.ArtistViewModel
import kotlinx.android.synthetic.main.activity_main.*
import androidx.navigation.ui.NavigationUI
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.exercise_retrofit.AppContainer
import com.example.exercise_retrofit.MyApplication
import com.example.exercise_retrofit.R
import com.example.exercise_retrofit.artist.ArtistAPI
import com.example.exercise_retrofit.artist.ArtistRepository
import com.example.exercise_retrofit.config.RetrofitBuilder

class MainActivity : AppCompatActivity() {

    lateinit var navController: NavController
    lateinit var appContainer: AppContainer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // manggil di activity cuma application
        //val appContainer = (application as MyApplication).appContainer
        //appContainer.artistViewModel

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

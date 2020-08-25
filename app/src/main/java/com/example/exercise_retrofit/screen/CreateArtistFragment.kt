package com.example.exercise_retrofit.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.exercise_retrofit.AppContainer
import com.example.exercise_retrofit.MyApplication
import com.example.exercise_retrofit.R
import com.example.exercise_retrofit.artist.Artist
import com.example.exercise_retrofit.artist.ArtistViewModel
import kotlinx.android.synthetic.main.fragment_create_artist.*

/**
 * A simple [Fragment] subclass.
 * Use the [CreateArtistFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CreateArtistFragment : Fragment(), View.OnClickListener {

    lateinit var appContainer: AppContainer
    //val artistViewModel by activityViewModels<ArtistViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appContainer = (activity?.application as MyApplication).appContainer
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_artist, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        submitArtistButton.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v) {
            submitArtistButton -> {
                val artist = Artist(
                    name = artistNameInputText.text.toString(),
                    bornPlace = artistBornPlaceInputText.text.toString(),
                    debut = artistDebutInputText.text.toString()
                )
                appContainer.artistViewModel.saveArtist(artist)
            }
        }
    }
}

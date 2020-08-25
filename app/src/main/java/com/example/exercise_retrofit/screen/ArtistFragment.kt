package com.example.exercise_retrofit.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.exercise_retrofit.AppContainer
import com.example.exercise_retrofit.MyApplication
import com.example.exercise_retrofit.R
import com.example.exercise_retrofit.artist.ArtistViewModel
import kotlinx.android.synthetic.main.fragment_artist.*

/**
 * A simple [Fragment] subclass.
 * Use the [ArtistFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ArtistFragment : Fragment(), View.OnClickListener {

    lateinit var appContainer: AppContainer

    // sama kaya merintahin activitynya untuk bikin view model
    //val artistViewModel by activityViewModels<ArtistViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // manggil di fragment pake activity.application
        appContainer = (activity?.application as MyApplication).appContainer
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_artist, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        appContainer.artistViewModel.artist.observe(viewLifecycleOwner, Observer {
            artistNameText.text = it.name
        })
        fetchButton.setOnClickListener(this)
    }

    fun getArtist() {
        appContainer.artistViewModel.getArtist(artistIdInputText.text.toString())
    }

    override fun onClick(v: View?) {
        when(v) {
            fetchButton -> getArtist()
        }
    }
}

package com.olympus.navigationaudio.mobile

import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.olympus.navigationaudio.R
import com.olympus.navigationaudio.backend.MediaService

class PlayerFragment(private val mediaPlayer: MediaPlayer, private val imageSource : String) : Fragment() {

    lateinit var fragmentPlayerImage : ImageView
    lateinit var fragmentPlayerButtonStop : ImageButton
    lateinit var fragmentPlayerButtonPlay : ImageButton
    lateinit var fragmentPlayerButtonCast : ImageButton
    lateinit var mediaService : MediaService
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_player, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize(view)

        if (imageSource != "") {
            Glide.with(this).load(imageSource).into(fragmentPlayerImage)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = PlayerFragment
    }

    fun initialize(view: View){
        fragmentPlayerImage = view.findViewById(R.id.fragmentPlayerImage)
        fragmentPlayerButtonStop = view.findViewById(R.id.fragmentPlayerButtonStop)
        fragmentPlayerButtonPlay = view.findViewById(R.id.fragmentPlayerButtonPlay)
        fragmentPlayerButtonCast = view.findViewById(R.id.fragmentPlayerButtonCast)
        mediaService = MediaService()
        setListeners()

    }

    fun setListeners(){
        fragmentPlayerButtonStop.setOnClickListener {
            mediaService.stopMedia(mediaPlayer)
        }

        fragmentPlayerButtonPlay.setOnClickListener {
            mediaService.resumeMedia(mediaPlayer)
        }

        fragmentPlayerButtonCast.setOnClickListener{
            // TODO cast media
        }
    }
}

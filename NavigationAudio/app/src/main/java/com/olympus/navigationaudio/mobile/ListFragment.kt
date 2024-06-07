package com.olympus.navigationaudio.mobile

import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.olympus.navigationaudio.R
import com.olympus.navigationaudio.backend.ServerData
import com.olympus.navigationaudio.backend.ServerDataAdapter

class ListFragment(mediaPlayerSource : MediaPlayer) : Fragment() {
    var mediaPlayer: MediaPlayer = mediaPlayerSource
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView(view)

    }

    companion object {
        @JvmStatic
        fun newInstance() = LoginFragment()
    }

    fun initRecyclerView(view: View){
        val serverData = ServerData()
        val (modules, subjects, lessons) = serverData.getDataParsed(serverData.data,"username","password")
        val lessonList = lessons
        val recyclerView = view.findViewById<RecyclerView>(R.id.fragment_list_recyclerview)
        val transaction = requireActivity().supportFragmentManager.beginTransaction()
        recyclerView.layoutManager = LinearLayoutManager(this.context)
        recyclerView.adapter = ServerDataAdapter(lessonList, subjects, transaction, mediaPlayer)

    }

    public fun returnMediaPlayer(): MediaPlayer {
        return mediaPlayer
    }
}

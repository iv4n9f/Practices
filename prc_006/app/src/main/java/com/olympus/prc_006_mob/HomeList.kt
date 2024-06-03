package com.olympus.prc_006_mob

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController

class HomeList : Fragment() {

    private lateinit var musicPlayer: MusicPlayer
    private val musicData = MusicData()
    private lateinit var listView: ListView
    private lateinit var musicListAdapter: ArrayAdapter<String>
    private lateinit var musicList: MusicData.MusicList

    val jsonString = """
        {
          "music": [
            {
              "id": "audio_sample_0.mp3",
              "title": "Audioclase 1",
              "album": "Audioclases Universae",
              "artist": "Universae",
              "genre": "Audioclases",
              "source": "https://drive.google.com/uc?export=download&id=1i-nwNgNxqP7xxY3DVnuAoQoFfNWJp4yC",
              "image": "https://drive.google.com/uc?export=download&id=1rJWiQ5zjkrrqezIkPoxiI7e9WocV1OYe",
              "trackNumber": 1,
              "totalTrackCount": 4,
              "duration": 600,
              "site": "https://www.universae.com"
            },
            {
              "id": "audio_sample_1.mp3",
              "title": "Audioclase 2",
              "album": "Audioclases Universae",
              "artist": "Universae",
              "genre": "Audioclases",
              "source": "https://drive.google.com/uc?export=download&id=1CF_bunf_WsN1mRpGXCHWvYdwkZsblaXE",
              "image": "https://drive.google.com/uc?export=download&id=1rJWiQ5zjkrrqezIkPoxiI7e9WocV1OYe",
              "trackNumber": 2,
              "totalTrackCount": 4,
              "duration": 600,
              "site": "https://www.universae.com"
            },
            {
              "id": "audio_sample_2.mp3",
              "title": "Audioclase 3",
              "album": "Audioclases Universae",
              "artist": "Universae",
              "genre": "Audioclases",
              "source": "https://drive.google.com/uc?export=download&id=1L7g2gNLV3oUI_zXWH6nkYZN0-Tj_62jQ",
              "image": "https://drive.google.com/uc?export=download&id=1rJWiQ5zjkrrqezIkPoxiI7e9WocV1OYe",
              "trackNumber": 3,
              "totalTrackCount": 4,
              "duration": 600,
              "site": "https://www.universae.com"
            },
            {
              "id": "audio_sample_3.mp3",
              "title": "Audioclase 4",
              "album": "Audioclases Universae",
              "artist": "Universae",
              "genre": "Audioclases",
              "source": "https://drive.google.com/uc?export=download&id=1R7w7tubsgfgcRs5p8bZD7LkuEfNnpzm-",
              "image": "https://drive.google.com/uc?export=download&id=1rJWiQ5zjkrrqezIkPoxiI7e9WocV1OYe",
              "trackNumber": 4,
              "totalTrackCount": 4,
              "duration": 600,
              "site": "https://www.universae.com"
            }
          ]
        }
    """.trimIndent()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home_list, container, false)

        listView = view.findViewById(R.id.home_list_list)
        musicList = musicData.getMusicData(jsonString)

        val musicTitles = musicList.music.map { it.title }
        musicListAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, musicTitles)
        listView.adapter = musicListAdapter

        listView.setOnItemClickListener { _, _, position, _ ->
            val selectedMusic = musicList.music[position]
        }

        musicPlayer = MusicPlayer(requireContext())
        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeList().apply {
            }
    }
}


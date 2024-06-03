package com.olympus.prc_006_mob

import com.google.gson.Gson

class MusicData {
    data class Music(
        val id: String,
        val title: String,
        val album: String,
        val artist: String,
        val genre: String,
        val source: String,
        val image: String,
        val trackNumber: Int,
        val totalTrackCount: Int,
        val duration: Int,
        val site: String
    )
    data class MusicList(
        val music: List<Music>
    )

    public fun getMusicData(json: String): MusicList {
        return Gson().fromJson(json, MusicList::class.java)
    }

}
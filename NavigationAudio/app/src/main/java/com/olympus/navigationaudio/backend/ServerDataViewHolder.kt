package com.olympus.navigationaudio.backend

import android.content.Context
import android.media.MediaPlayer
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.olympus.navigationaudio.R

class ServerDataViewHolder(private val context: Context, view: View, private val mediaPlayer: MediaPlayer) : RecyclerView.ViewHolder(view) {
    private val lessonImage: ImageView = view.findViewById(R.id.lessonElementCardviewLayoutImage)
    private val lessonName: TextView = view.findViewById(R.id.lessonElementCardviewLayoutTitle)
    private val lessonDuration: TextView = view.findViewById(R.id.lessonElementCardviewLayoutDuration)
    private val lessonNumber: TextView = view.findViewById(R.id.lessonElementCardviewLayoutNumber)
    private val button: ImageButton = view.findViewById(R.id.lessonElementCardviewLayoutButton)

    fun renderLesson(lesson: ServerData.Lesson, subject: ServerData.Subject) {
        lessonName.text = lesson.name
        lessonDuration.text = "Duration : ${lesson.duration / 100} min"
        lessonNumber.text = "Lesson : ${lesson.number}"
        Glide.with(context).load(lesson.image).into(lessonImage)

        button.setOnClickListener {
            val mediaManager = MediaService()
            mediaManager.playMedia(context, lesson.name, lesson.audio, mediaPlayer)
        }
    }
}
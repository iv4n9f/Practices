package com.olympus.navigationaudio.backend

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.olympus.navigationaudio.R

class ServerDataViewHolder(view: View):RecyclerView.ViewHolder(view) {

    val lessonImage: ImageView = view.findViewById<ImageView>(R.id.lessonElementCardviewLayoutImage)
    val lessonName: TextView = view.findViewById<TextView>(R.id.lessonElementCardviewLayoutTitle)
    val lessonDuration : TextView = view.findViewById<TextView>(R.id.lessonElementCardviewLayoutDuration)
    val lessonNumber : TextView = view.findViewById<TextView>(R.id.lessonElementCardviewLayoutNumber)
    fun renderLesson(lesson: ServerData.Lesson){
        lessonName.text = lesson.name
        lessonDuration.text = lesson.duration.toString()
        lessonNumber.text = lesson.number.toString()
    }

}
package com.olympus.navigationaudio.backend

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.olympus.navigationaudio.R

class ServerDataViewHolder(view: View):RecyclerView.ViewHolder(view) {

    val lessonImage: ImageView = view.findViewById<ImageView>(R.id.lessonElementCardviewLayoutImage)
    val lessonName: TextView = view.findViewById<TextView>(R.id.lessonElementCardviewLayoutTitle)
    val lessonDuration : TextView = view.findViewById<TextView>(R.id.lessonElementCardviewLayoutDuration)
    val lessonNumber : TextView = view.findViewById<TextView>(R.id.lessonElementCardviewLayoutNumber)
    fun renderLesson(lesson: ServerData.Lesson, subject: ServerData.Subject){
        lessonName.text = lesson.name
        lessonDuration.text = ("Duration : " + (lesson.duration / 100).toString() + " min")
        lessonNumber.text = ("Lesson : " + (lesson.number).toString())
        Glide.with(itemView.context).load(lesson.image).into(lessonImage)
    }

}
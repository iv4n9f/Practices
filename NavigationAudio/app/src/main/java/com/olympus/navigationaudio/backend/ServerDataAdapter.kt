package com.olympus.navigationaudio.backend

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.olympus.navigationaudio.R

class ServerDataAdapter(private val lessonList: List<ServerData.Lesson>, private val subjectList : List<ServerData.Subject> ) : RecyclerView.Adapter<ServerDataViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServerDataViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return  ServerDataViewHolder(layoutInflater.inflate(R.layout.lesson_cardview, parent, false ))
    }

    override fun getItemCount(): Int {
        return lessonList.count()
    }

    override fun onBindViewHolder(holder: ServerDataViewHolder, position: Int) {
        val item = lessonList[position]
        val subject = subjectList[position]
        holder.renderLesson(item, subject)
    }

}
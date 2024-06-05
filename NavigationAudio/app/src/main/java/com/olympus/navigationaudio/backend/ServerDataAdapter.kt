package com.olympus.navigationaudio.backend
import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.olympus.navigationaudio.R

class ServerDataAdapter(private val lessonList: List<ServerData.Lesson>, private val subjectList: List<ServerData.Subject>) : RecyclerView.Adapter<ServerDataViewHolder>() {
    private val mediaPlayer: MediaPlayer = MediaPlayer()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServerDataViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ServerDataViewHolder(parent.context, layoutInflater.inflate(R.layout.lesson_cardview, parent, false), mediaPlayer)
    }

    override fun getItemCount(): Int {
        return lessonList.size
    }

    override fun onBindViewHolder(holder: ServerDataViewHolder, position: Int) {
        val item = lessonList[position]
        val subject = subjectList[position]
        holder.renderLesson(item, subject)
    }
    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        super.onDetachedFromRecyclerView(recyclerView)
        mediaPlayer.release()
    }
}

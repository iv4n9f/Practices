package com.olympus.prc_006_mob

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.olympus.prc_006_mob.MusicData.Music
import com.olympus.prc_006_mob.R

class MusicAdapter(private val musicList: List<Music>) :
    RecyclerView.Adapter<MusicAdapter.MusicViewHolder>() {

    inner class MusicViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.lesson_card_view_title)
        val album: TextView = itemView.findViewById(R.id.lesson_card_view_album)
        val author: TextView = itemView.findViewById(R.id.lesson_card_view_author)
        val duration: TextView = itemView.findViewById(R.id.lesson_card_view_duration)
        val playButton: ImageButton = itemView.findViewById(R.id.lesson_card_view_play_button)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.lesson_card, parent, false)
        return MusicViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MusicViewHolder, position: Int) {
        val currentItem = musicList[position]

        holder.title.text = currentItem.title
        holder.album.text = "Album: ${currentItem.album}"
        holder.author.text = "Autor: ${currentItem.artist}"
        holder.duration.text = "Duration: ${currentItem.duration} min"

        // Aquí puedes cargar la imagen si tienes una URL en currentItem.image
        // Glide se usa aquí como una biblioteca de carga de imágenes, asegúrate de agregarla a tu proyecto
        // Glide.with(holder.itemView.context).load(currentItem.image).apply(RequestOptions().centerCrop()).into(holder.imageView)

        holder.playButton.setOnClickListener {
            // Aquí puedes agregar la lógica para reproducir la música
        }
    }

    override fun getItemCount() = musicList.size
}

package com.olympus.navigationaudio.backend

import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.os.IBinder
import android.support.v4.media.MediaBrowserCompat
import android.support.v4.media.MediaDescriptionCompat
import androidx.media.MediaBrowserServiceCompat
import java.io.IOException

class MediaService : MediaBrowserServiceCompat() {

    var mediaPlayerCurrent: MediaPlayer? = null
    lateinit var lessonList : List<ServerData.Lesson>

    companion object {
        private const val ROOT_ID = "com.olympus.navigationaudio.root"
    }
    override fun onCreate() {
        super.onCreate()
        val serverData = ServerData()
        val (modules, subjects, lessons) = serverData.getDataParsed(serverData.data,"username","password")
        lessonList = lessons
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return START_STICKY
    }

    fun playMedia(context: Context, name: String,url: String, mediaPlayer: MediaPlayer) {
        mediaPlayerCurrent = mediaPlayer
        mediaPlayer.let {
            try {
                it.reset()
                it.setDataSource(url)
                it.prepare()
                it.start()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }

    fun stopMedia(mediaPlayer: MediaPlayer) {
        mediaPlayer.let {
            if (it.isPlaying) {
                it.pause()
            }
        }
    }

    fun resumeMedia(mediaPlayer: MediaPlayer) {
        mediaPlayer.let {
            if (!it.isPlaying) {
                it.start()
            }
        }
    }

    fun getMediaPlayer() : MediaPlayer? {
        return mediaPlayerCurrent
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayerCurrent?.release()
        mediaPlayerCurrent = null
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onGetRoot(
        clientPackageName: String,
        clientUid: Int,
        rootHints: Bundle?
    ): BrowserRoot? {
        TODO("Not yet implemented")
    }

    override fun onLoadChildren(
        parentId: String,
        result: Result<MutableList<MediaBrowserCompat.MediaItem>>
    ) {
        // Verificar si el parentId es el root o si coincide con algún otro ID esperado
        if (parentId == ROOT_ID) {
            // Si el parentId es el root, cargar los elementos multimedia principales
            result.sendResult(createMediaItemsForRoot())
        } else {
            // De lo contrario, cargar los elementos multimedia correspondientes al parentId
            result.sendResult(createMediaItemsForParent(parentId))
        }
    }

    private fun createMediaItemsForRoot(): MutableList<MediaBrowserCompat.MediaItem> {
        // Aquí deberías crear y devolver una lista de elementos multimedia principales
        // Esta lista puede incluir álbumes, canciones, listas de reproducción, etc.
        // Puedes obtener la lista de lecciones desde tu variable lessonList y convertirla en elementos multimedia

        val mediaItems = mutableListOf<MediaBrowserCompat.MediaItem>()

        // Iterar sobre la lista de lecciones y convertirla en elementos multimedia
        for (lesson in lessonList) {
            val audioUri = Uri.parse(lesson.audio)
            // Crear un MediaDescriptionCompat para representar cada lección como un elemento multimedia
            val mediaDescription = MediaDescriptionCompat.Builder()
                .setMediaId(lesson.number.toString()) // Usar el ID de la lección como ID multimedia
                .setTitle(lesson.name) // Usar el nombre de la lección como título multimedia
                .setMediaUri(audioUri)
                .build()


            // Crear un MediaItem con el MediaDescriptionCompat creado
            val mediaItem = MediaBrowserCompat.MediaItem(
                mediaDescription,
                MediaBrowserCompat.MediaItem.FLAG_PLAYABLE
            )

            // Agregar el MediaItem a la lista de elementos multimedia
            mediaItems.add(mediaItem)
        }

        return mediaItems
    }

    private fun createMediaItemsForParent(parentId: String): MutableList<MediaBrowserCompat.MediaItem> {
        // Aquí deberías crear y devolver una lista de elementos multimedia para el parentId proporcionado
        // Puedes implementar la lógica para cargar elementos multimedia específicos según sea necesario

        // Por ejemplo, si tienes una estructura jerárquica de elementos multimedia, puedes cargar
        // subelementos multimedia correspondientes al parentId

        return mutableListOf() // Devolver una lista vacía como ejemplo
    }

}

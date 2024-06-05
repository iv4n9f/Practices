package com.olympus.navigationaudio.backend

import android.Manifest
import android.app.PendingIntent
import android.app.Service.START_NOT_STICKY
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.media.MediaPlayer
import android.os.IBinder
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.olympus.navigationaudio.R

class MediaService {
    companion object {
        private const val CHANNEL_ID = "MediaPlaybackChannel"
        private const val NOTIFICATION_ID = 101

        private var notificationId = 0
        private val mediaPlayerMap: MutableMap<Int, MediaPlayer> = mutableMapOf()
        private var mediaPlayerIdCounter = 0
    }

    fun playMedia(context: Context, name: String ,url: String, mediaPlayer: MediaPlayer) {
        stopMedia(mediaPlayer)
        showNotification(context, name, mediaPlayer, url)
        mediaPlayer.apply {
            setDataSource(url)
            prepare()
            start()
        }
    }

    fun stopMedia(mediaPlayer: MediaPlayer) {
        mediaPlayer.apply {
            if (isPlaying) {
                stop()
            }
            reset()
        }
    }

    private fun pauseMedia(mediaPlayer: MediaPlayer) {
        mediaPlayer?.pause()
    }

    fun onBind(intent: Intent?): IBinder? {
        return null
    }
    fun onStartCommand(context: Context, name: String, intent: Intent?, flags: Int, startId: Int): Int {
        if (intent != null && intent.action != null) {
            when (intent.action) {
                "PLAY" -> {
                    val url = intent.getStringExtra("URL")
                    val mediaPlayerId = mediaPlayerIdCounter++
                    val mediaPlayer = MediaPlayer().apply {
                        setDataSource(url)
                        prepare()
                        start()
                    }
                    mediaPlayerMap[mediaPlayerId] = mediaPlayer
                    showNotification(context, name , mediaPlayer, "Now Playing")
                }
                "PAUSE" -> {
                    // Pausar reproducción del MediaPlayer asociado al ID
                    val mediaPlayerId = intent.getIntExtra("MEDIA_PLAYER_ID", -1)
                    mediaPlayerMap[mediaPlayerId]?.pause()
                }
            }
        }
        return START_NOT_STICKY
    }

    private fun showNotification(context: Context,notificationTitle: String, mediaPlayer: MediaPlayer, url: String) {
        val playIntent = Intent(context, MediaBroadcastReceiver::class.java).apply {
            action = "PLAY"
            putExtra("URL", url)
        }
        val pauseIntent = Intent(context, MediaBroadcastReceiver::class.java).apply {
            action = "PAUSE"
        }
        val mediaPlayer = mediaPlayer
        val playPendingIntent = PendingIntent.getBroadcast(context, 0, playIntent, PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE)
        val pausePendingIntent = PendingIntent.getBroadcast(context, 0, pauseIntent, PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE)

        val playIcon = R.drawable.button_player
        val pauseIcon = R.drawable.button_pause

        val builder = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle(notificationTitle)
            .setContentText("Media is playing")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .addAction(playIcon, "Play", playPendingIntent) // Botón de play
            .addAction(pauseIcon, "Pause", pausePendingIntent) // Botón de pause

        with(NotificationManagerCompat.from(context)) {
            if (ActivityCompat.checkSelfPermission(
                    context,
                    Manifest.permission.POST_NOTIFICATIONS
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return
            }
            notify(notificationId, builder.build())
        }
    }


}





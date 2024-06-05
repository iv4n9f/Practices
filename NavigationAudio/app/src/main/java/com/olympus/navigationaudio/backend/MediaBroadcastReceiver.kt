package com.olympus.navigationaudio.backend

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class MediaBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val action = intent.action
        val serviceIntent = Intent(context, MediaService::class.java)
        when (action) {
            "PLAY" -> {
                val url = intent.getStringExtra("URL")
                serviceIntent.putExtra("ACTION", "PLAY")
                serviceIntent.putExtra("URL", url)
                context.startService(serviceIntent)
            }
            "PAUSE" -> {
                serviceIntent.putExtra("ACTION", "PAUSE")
                context.startService(serviceIntent)
            }
        }
    }
}

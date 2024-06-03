package com.olympus.prc_006_mob

import android.content.Context
import android.media.MediaPlayer
import android.net.Uri
import android.widget.Toast
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Streaming
import retrofit2.http.Url
import java.io.*

interface DownloadService {
    @Streaming
    @GET
    fun downloadFile(@Url fileUrl: String): Call<ResponseBody>
}

class MusicPlayer(private val context: Context) {
    private var mediaPlayer: MediaPlayer? = null

    fun downloadFile(url: String, fileName: String) {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://your_base_url/") // Coloca la URL base de tu servicio aquí
            .build()

        val service = retrofit.create(DownloadService::class.java)
        val call = service.downloadFile(url)

        call.enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if (response.isSuccessful) {
                    val writtenToDisk = writeResponseBodyToDisk(response.body(), fileName)
                    playAudioFile(fileName)
                    if (writtenToDisk) {
                        Toast.makeText(context, "Descarga exitosa", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(context, "Error al guardar el archivo", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(context, "Error en la respuesta: ${response.code()}", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Toast.makeText(context, "Error en la solicitud", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun writeResponseBodyToDisk(body: ResponseBody?, fileName: String): Boolean {
        if (body == null) return false

        try {
            val file = File(context.filesDir, fileName)
            val inputStream: InputStream = body.byteStream()
            val outputStream: OutputStream = FileOutputStream(file)
            val buffer = ByteArray(4096)
            var fileSizeDownloaded: Long = 0
            var read: Int
            while (inputStream.read(buffer).also { read = it } != -1) {
                outputStream.write(buffer, 0, read)
                fileSizeDownloaded += read.toLong()
            }
            outputStream.flush()
            outputStream.close()
            inputStream.close()
            return true
        } catch (e: IOException) {
            e.printStackTrace()
            return false
        }
    }

    private fun playAudioFile(fileName: String) {
        mediaPlayer?.release()

        val file = File(context.filesDir, fileName)

        mediaPlayer = MediaPlayer().apply {
            setDataSource(context, Uri.fromFile(file))
            prepareAsync()
            setOnPreparedListener { start() }
        }
    }
}

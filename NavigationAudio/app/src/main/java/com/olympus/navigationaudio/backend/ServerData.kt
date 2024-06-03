package com.olympus.navigationaudio.backend

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ServerData {

    private val data = """ 
         {
           "music": [
             {
               "id": "audio_sample_0.mp3",
               "title": "Audioclase 1",
               "album": "Audioclases Universae",
               "artist": "Universae",
               "genre": "Audioclases",
               "source": "https://drive.google.com/uc?export=download&id=1i-nwNgNxqP7xxY3DVnuAoQoFfNWJp4yC",
               "image": "https://drive.google.com/uc?export=download&id=1rJWiQ5zjkrrqezIkPoxiI7e9WocV1OYe",
               "trackNumber": 1,
               "totalTrackCount": 4,
               "duration": 600,
               "site": "https://www.universae.com"
             },
             {
               "id": "audio_sample_1.mp3",
               "title": "Audioclase 2",
               "album": "Audioclases Universae",
               "artist": "Universae",
               "genre": "Audioclases",
               "source": "https://drive.google.com/uc?export=download&id=1CF_bunf_WsN1mRpGXCHWvYdwkZsblaXE",
               "image": "https://drive.google.com/uc?export=download&id=1rJWiQ5zjkrrqezIkPoxiI7e9WocV1OYe",
               "trackNumber": 2,
               "totalTrackCount": 4,
               "duration": 600,
               "site": "https://www.universae.com"
             },
             {
               "id": "audio_sample_2.mp3",
               "title": "Audioclase 3",
               "album": "Audioclases Universae",
               "artist": "Universae",
               "genre": "Audioclases",
               "source": "https://drive.google.com/uc?export=download&id=1L7g2gNLV3oUI_zXWH6nkYZN0-Tj_62jQ",
               "image": "https://drive.google.com/uc?export=download&id=1rJWiQ5zjkrrqezIkPoxiI7e9WocV1OYe",
               "trackNumber": 3,
               "totalTrackCount": 4,
               "duration": 600,
               "site": "https://www.universae.com"
             },
             {
               "id": "audio_sample_3.mp3",
               "title": "Audioclase 4",
               "album": "Audioclases Universae",
               "artist": "Universae",
               "genre": "Audioclases",
               "source": "https://drive.google.com/uc?export=download&id=1R7w7tubsgfgcRs5p8bZD7LkuEfNnpzm-",
               "image": "https://drive.google.com/uc?export=download&id=1rJWiQ5zjkrrqezIkPoxiI7e9WocV1OYe",
               "trackNumber": 4,
               "totalTrackCount": 4,
               "duration": 600,
               "site": "https://www.universae.com"
             }
             ]
         }
    """.trimIndent()
    data class Module(val name: String)
    data class Subject(val name: String, val number: Int,  val module: Module)
    data class Lesson(val name: String, val number: Int, val audio: String, val duration: Int, val image: String, val subject: Subject)
    fun getServerData(user:String, password:String): String {
        // TODO Send the request to the server and save the returned data
        return data
    }

    fun getDataParsed(data: String, user: String, password: String): Triple<List<Module>, List<Subject>, List<Lesson>> {
        val gson = Gson()
        val serverData = gson.fromJson<Map<String, List<Map<String, Any>>>>(getServerData(user, password), object : TypeToken<Map<String, List<Map<String, Any>>>>() {}.type)

        val modules = mutableListOf<Module>()
        val subjects = mutableListOf<Subject>()
        val lessons = mutableListOf<Lesson>()

        val musicList = serverData["music"] ?: emptyList<Map<String, Any>>()

        for (music in musicList) {
            val moduleName = music["album"] as String
            val module = Module(moduleName)
            modules.add(module)

            val subjectName = music["album"] as String
            val subjectTotal = music["totalTrackCount"] as Double
            val moduleObject = Module(moduleName)
            val subject = Subject(subjectName, subjectTotal.toInt(), moduleObject)
            subjects.add(subject)

            val lessonName = music["title"] as String
            val lessonNumber = music["trackNumber"] as Double
            val lessonAudio = music["source"] as String
            val lessonDuration = music["duration"] as Double
            val lessonImage = music["image"] as String
            val lesson = Lesson(
                lessonName,
                lessonNumber.toInt(),
                lessonAudio,
                lessonDuration.toInt(),
                lessonImage,
                subject
            )
            lessons.add(lesson)
        }

        return Triple(modules, subjects, lessons)
    }

}
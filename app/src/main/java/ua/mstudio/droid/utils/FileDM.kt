package ua.mstudio.droid.utils

import okhttp3.*
import java.io.IOException

class FileDM  {

    private val client = OkHttpClient()

    fun read(url : String): String{
        val request = Request.Builder()
            .url(url)
            .build()

        var fileData = ""

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace()
            }

            override fun onResponse(call: Call, response: Response) {
                response.use {
                    if (!response.isSuccessful) throw IOException("Unexpected code $response")
                    fileData = response.body!!.string()
                }
            }
        })
        return fileData
    }

}
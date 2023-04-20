package ua.makuta.storylog.fragment.android

import android.util.Log
import okhttp3.Call
import okhttp3.Callback
import okhttp3.Request
import okhttp3.Response
import ua.makuta.storylog.Utils
import ua.makuta.storylog.model.Model
import ua.makuta.storylog.net.API
import java.io.IOException

class FAndroidPresenter(private val view : FAndroidContract.IView) : FAndroidContract.IPresenter {

    override fun onLoad() {
        val request = Request.Builder()
            .url(API.BASE_URL + API.DROID)
            .build()

        client().newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                view.onLoadFailed("Something went wrong")
                e.printStackTrace()
            }

            override fun onResponse(call: Call, response: Response) {
                response.use {
                    if (!response.isSuccessful) throw IOException("Unexpected code $response")
                    else {
                        val resp = response.body.string()
                        Log.i("WTF", resp)
                        val array = Utils.GSON().fromJson(resp,Array<Model>::class.java).toCollection(ArrayList())
                        view.onLoadSuccess(array)
                    }
                }
            }
        })
    }

}
package ua.makuta.storylog.fragment.wearOS

import android.util.Log
import okhttp3.Call
import okhttp3.Callback
import okhttp3.Request
import okhttp3.Response
import ua.makuta.storylog.Utils
import ua.makuta.storylog.core.CoreContract
import ua.makuta.storylog.fragment.ios.FIosContract
import ua.makuta.storylog.model.Model
import ua.makuta.storylog.net.API
import java.io.IOException

class FWearPresenter(private val view : FWearContract.IView) : FWearContract.IPresenter {

    override fun onLoad() {
        val request = Request.Builder()
            .url(API.BASE_URL + API.WEAR)
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
                        val resp = response.body!!.string()
                        Log.i("WTF", resp)
                        val array = Utils.GSON().fromJson(resp,Array<Model>::class.java).toCollection(ArrayList())
                        view.onLoadSuccess(array)
                    }
                }
            }
        })
    }
}
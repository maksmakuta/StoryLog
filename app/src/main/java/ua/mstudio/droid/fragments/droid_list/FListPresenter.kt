package ua.mstudio.droid.fragments.droid_list

import android.util.Log
import com.google.gson.Gson
import okhttp3.*
import ua.mstudio.droid.model.DroidVersion
import ua.mstudio.droid.net.API
import java.io.IOException

class FListPresenter(val view : FListContract.IView) : FListContract.IPresenter {

    override fun load() {
        val url = API.BASE_URL + API.GET_LIST
        view.showLoader()

        Log.i("WTF","FListPresenter::load() URL -> $url")

        val request: Request = Request.Builder()
            .url(url)
            .addHeader("Content-Type", "application/json")
            .addHeader("Accept", "application/json")
            .build()

        getOkhttp().newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace()
                Log.i("WTF","FListPresenter::load() onFailure json = ${call.request().url}")
                view.showMessage("Error from server")
            }

            @Throws(IOException::class)
            override fun onResponse(call: Call, response: Response) {
                val resp = response.body!!.string()
                val code = response.code
                Log.i("WTF","FListPresenter::load() code = $code")
                Log.i("WTF","FListPresenter::load() JSON = $resp")
                if(code == 200) {
                    view.hideLoader()
                    val obj = Gson().fromJson(resp,Array<DroidVersion>::class.java)
                    if(obj != null)
                        view.onResult(obj.toCollection(ArrayList()))
                }else{
                    view.showMessage("Error from server")
                }
            }
        })
    }
}
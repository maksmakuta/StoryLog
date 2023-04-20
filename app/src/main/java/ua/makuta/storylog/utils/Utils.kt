package ua.makuta.storylog.utils

import android.util.Log
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.gson.Gson
import com.google.gson.GsonBuilder

object Utils {

    const val ARGS_LIST = "args_list"

    fun AdView.load(){
        this.loadAd(AdRequest.Builder().build())
    }

    fun logger(msg : String){
        Log.d("App",msg)
    }

    val gson : Gson
        get() = GsonBuilder()
            .serializeNulls()
            .create()
}
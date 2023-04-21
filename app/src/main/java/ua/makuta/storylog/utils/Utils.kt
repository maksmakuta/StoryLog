package ua.makuta.storylog.utils

import android.util.Log
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.fragment.app.Fragment
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.material.snackbar.Snackbar
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import ua.makuta.storylog.core.CoreFragment

object Utils {

    const val ARGS_LIST     = "args_list"
    const val ARGS_TITLE    = "args_title"
    const val ARGS_TYPE     = "args_type"

    fun View.gone(){
        this.visibility = GONE
    }

    fun View.visible(){
        this.visibility = VISIBLE
    }

    fun AdView.load(){
        this.loadAd(AdRequest.Builder().build())
    }

    fun logger(msg : String){
        Log.d("App",msg)
    }

    fun Fragment.snack(str : Int, vararg args : Any){
        Snackbar.make(this.requireView(),getString(str,args),Snackbar.LENGTH_SHORT).show()
    }

    val gson : Gson
        get() = GsonBuilder()
            .serializeNulls()
            .create()
}
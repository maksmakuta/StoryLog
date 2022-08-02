package ua.makuta.storylog

import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import com.google.android.material.snackbar.Snackbar
import com.google.gson.Gson
import com.google.gson.GsonBuilder

object Utils {

    fun View.visible(){
        this.visibility = VISIBLE
    }

    fun View.invisible(){
        this.visibility = GONE
    }

    fun String.toLog() : String{
        var temp = this
        temp = temp.replace("_","\n\t - ")
        temp = temp.replace("*","\n - ")
        return temp
    }

    fun GSON() : Gson{
        return GsonBuilder()
            .setPrettyPrinting()
            .serializeNulls()
            .create()
    }

    fun View.snack(msg : String){
        Snackbar
            .make(this,msg,Snackbar.LENGTH_SHORT)
            .setAnimationMode(Snackbar.ANIMATION_MODE_SLIDE)
            .show()
    }

}
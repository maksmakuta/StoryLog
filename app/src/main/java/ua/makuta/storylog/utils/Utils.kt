package ua.makuta.storylog.utils

import android.util.Log
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.TextView
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.material.snackbar.Snackbar
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import io.noties.markwon.Markwon

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

    fun TextView.markdown(text : String){
        val markwon = Markwon.create(this.context)
        markwon.setMarkdown(this,text)
    }

    fun logger(msg : String){
        Log.d("App",msg)
    }

    fun Fragment.snack(@StringRes str : Int,anchor : View? = null){
        val s = Snackbar
            .make(this.requireView(),getString(str),Snackbar.LENGTH_SHORT)
            if(anchor != null) s.anchorView = anchor
            s.show()
    }

    val gson : Gson
        get() = GsonBuilder()
            .serializeNulls()
            .create()
}
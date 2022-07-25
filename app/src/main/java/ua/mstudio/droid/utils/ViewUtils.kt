package ua.mstudio.droid.utils

import android.view.View
import android.view.View.*

object ViewUtils {

    fun View.visible(){
        this.visibility = VISIBLE
    }

    fun View.invisible(){
        this.visibility = INVISIBLE
    }

    fun View.gone(){
        this.visibility = GONE
    }

}
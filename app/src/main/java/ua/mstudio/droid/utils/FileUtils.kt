package ua.mstudio.droid.utils

import android.content.Context

class FileUtils {

    fun mainData(ctx : Context) : String{
        return load("list.json",ctx)
    }

    fun loadStory(code : Int,ctx : Context): String {
        return load("android$code.json",ctx)
    }

    private fun load(name : String,ctx : Context) : String{
        return ctx.assets.open(name).bufferedReader().use{it.readText()}
    }
}
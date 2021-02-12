package ua.mstudio.droid

import android.app.Application
import android.content.Context

class Droid : Application() {

    lateinit var ctx : Context

    override fun onCreate() {
        super.onCreate()
        ctx = applicationContext
    }

    fun ctx() : Context {return ctx}

}
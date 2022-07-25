package ua.mstudio.droid

import android.app.Application
import com.google.android.material.color.DynamicColors

class Droid : Application() {

    override fun onCreate() {
        super.onCreate()
        DynamicColors.applyToActivitiesIfAvailable(this)
    }

}
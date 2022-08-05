package ua.makuta.storylog

import android.app.Application
import com.google.android.material.color.DynamicColors

class StoryLogApp : Application() {

    override fun onCreate() {
        super.onCreate()

        DynamicColors.applyToActivitiesIfAvailable(this)
    }

}
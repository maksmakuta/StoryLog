package ua.mstudio.droid.utils

import android.content.Context
import android.content.res.Configuration
import android.graphics.Color
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity

class ThemeUtils {

    fun isDarkTheme(ctx: Context): Boolean {
        return ctx.resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK == Configuration.UI_MODE_NIGHT_YES
    }

    fun draw(activity: AppCompatActivity) {
        activity.window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        if (isDarkTheme(activity.applicationContext))
            activity.window.statusBarColor = Color.BLACK
    }
}

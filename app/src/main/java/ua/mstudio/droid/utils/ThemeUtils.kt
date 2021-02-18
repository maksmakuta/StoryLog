package ua.mstudio.droid.utils

import android.content.Context
import android.content.res.Configuration

fun isDarkTheme(ctx : Context) : Boolean{
    return ctx.resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK == Configuration.UI_MODE_NIGHT_YES
}
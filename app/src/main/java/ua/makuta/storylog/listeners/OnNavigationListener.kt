package ua.makuta.storylog.listeners

import android.view.View

interface OnNavigationListener {
    fun onHide()
    fun onShow()
    fun onView() : View
}
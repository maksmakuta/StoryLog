package ua.mstudio.droid.activity

import android.content.Context
import ua.mstudio.droid.utils.NetUtils

class MainPresenter(val view : MainContract.IView) : MainContract.IPresenter {

    override fun checkConnection(ctx: Context) {
        view.connectionExist(NetUtils.isInternetAvailable(ctx))
    }

}
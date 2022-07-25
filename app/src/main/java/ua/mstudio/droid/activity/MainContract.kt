package ua.mstudio.droid.activity

import android.content.Context
import ua.mstudio.droid.core.CoreContract

interface MainContract {

    interface IView : CoreContract.IView{
        fun connectionExist(hasConnection : Boolean)
    }

    interface IPresenter : CoreContract.IPresenter{
        fun checkConnection(ctx : Context)
    }

}
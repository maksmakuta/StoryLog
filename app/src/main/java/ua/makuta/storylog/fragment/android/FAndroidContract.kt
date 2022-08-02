package ua.makuta.storylog.fragment.android

import ua.makuta.storylog.core.CoreContract
import ua.makuta.storylog.model.Model

interface FAndroidContract {

    interface IView : CoreContract.IView{
        fun onLoadSuccess(data : ArrayList<Model>)
        fun onLoadFailed(msg : String)
    }

    interface IPresenter : CoreContract.IPresenter{
        fun onLoad()
    }

}
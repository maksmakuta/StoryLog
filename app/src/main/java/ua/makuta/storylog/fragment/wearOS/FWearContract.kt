package ua.makuta.storylog.fragment.wearOS

import ua.makuta.storylog.core.CoreContract
import ua.makuta.storylog.model.Model

interface FWearContract {

    interface IView : CoreContract.IView{
        fun onLoadSuccess(data : ArrayList<Model>)
        fun onLoadFailed(msg : String)
    }

    interface IPresenter : CoreContract.IPresenter{
        fun onLoad()
    }

}
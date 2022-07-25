package ua.mstudio.droid.fragments.droid_list

import ua.mstudio.droid.core.CoreContract
import ua.mstudio.droid.model.DroidVersion

class FListContract {

    interface IView : CoreContract.IView{
        fun showLoader()
        fun hideLoader()
        fun onResult(data : ArrayList<DroidVersion>)
        fun showMessage(msg : String)
    }

    interface IPresenter : CoreContract.IPresenter{
        fun load()
    }

}
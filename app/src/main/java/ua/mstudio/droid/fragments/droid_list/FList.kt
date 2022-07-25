package ua.mstudio.droid.fragments.droid_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.progressindicator.CircularProgressIndicator
import com.google.android.material.snackbar.Snackbar
import ua.mstudio.droid.R
import ua.mstudio.droid.adapter.VersionAdapter
import ua.mstudio.droid.core.CoreFragment
import ua.mstudio.droid.model.DroidVersion
import ua.mstudio.droid.utils.ViewUtils.gone
import ua.mstudio.droid.utils.ViewUtils.visible

class FList : CoreFragment(), FListContract.IView {

    private lateinit var presenter: FListPresenter

    private lateinit var items : RecyclerView
    private lateinit var adapter: VersionAdapter
    private lateinit var loader : CircularProgressIndicator

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        presenter = FListPresenter(this)
        return inflater.inflate(R.layout.fragment_list,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = VersionAdapter()
        items = view.findViewById(R.id.droid_list)
        items.adapter = adapter
        items.layoutManager = LinearLayoutManager(view.context)
        loader = view.findViewById(R.id.loader_list)
        presenter.load()
    }

    override fun showLoader() {
        loader.visible()
        items.gone()
        loader.show()
    }

    override fun hideLoader() {
        loader.gone()
        items.visible()
        loader.hide()
    }

    override fun onResult(data: ArrayList<DroidVersion>) {
        requireActivity().runOnUiThread {
            adapter.update(data)
        }
    }

    override fun showMessage(msg: String) {
        Snackbar
            .make(view!!,msg,Snackbar.LENGTH_SHORT)
            .setAnimationMode(Snackbar.ANIMATION_MODE_SLIDE)
            .show()
    }

}
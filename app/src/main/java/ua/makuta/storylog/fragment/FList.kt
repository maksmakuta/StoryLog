package ua.makuta.storylog.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import ua.makuta.storylog.activity.MainViewModel
import ua.makuta.storylog.adapter.AppAdapter
import ua.makuta.storylog.adapter.VersionAdapter
import ua.makuta.storylog.core.CoreFragment
import ua.makuta.storylog.databinding.FListBinding
import ua.makuta.storylog.enums.DataType
import ua.makuta.storylog.utils.Utils.ARGS_TITLE
import ua.makuta.storylog.utils.Utils.ARGS_TYPE

class FList: CoreFragment<FListBinding>() {

    private val mainVM : MainViewModel by activityViewModels()
    private val versionAdapter = VersionAdapter()
    private val appAdapter = AppAdapter()
    private var type = 0

    override fun onBinding(inflater: LayoutInflater, container: ViewGroup?) =
        FListBinding.inflate(inflater,container,false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listener.onHide()
        type = requireArguments().getInt(ARGS_TYPE,0)
        binding.title.text = requireArguments().getString(ARGS_TITLE,"")
        binding.list.apply {
            adapter = if(type == DataType.OS.ordinal) versionAdapter else appAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    override fun onResume() {
        super.onResume()
        when(type){
            DataType.OS.ordinal -> {
                mainVM.osData.observe(this) {
                    if (!it.isNullOrEmpty()) {
                        versionAdapter.addAll(it)
                    }
                }
            }
            DataType.APP.ordinal -> {
                mainVM.appData.observe(this) {
                    if (!it.isNullOrEmpty()) {
                        appAdapter.addAll(it)
                    }
                }
            }
            DataType.GAME.ordinal -> {
                mainVM.gameData.observe(this) {
                    if (!it.isNullOrEmpty()) {
                        appAdapter.addAll(it)
                    }
                }
            }
        }
    }

    override fun onStop() {
        super.onStop()
        (if(type == DataType.OS.ordinal) versionAdapter else appAdapter).clear()
        when(type){
            DataType.OS.ordinal -> {
                mainVM.osData.removeObservers(this)
            }
            DataType.APP.ordinal -> {
                mainVM.appData.removeObservers(this)
            }
            DataType.GAME.ordinal -> {
                mainVM.gameData.removeObservers(this)
            }
        }
    }


}
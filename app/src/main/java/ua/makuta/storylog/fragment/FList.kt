package ua.makuta.storylog.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import ua.makuta.storylog.activity.MainViewModel
import ua.makuta.storylog.adapter.AppAdapter
import ua.makuta.storylog.core.CoreFragment
import ua.makuta.storylog.databinding.FListBinding
import ua.makuta.storylog.listeners.OnItemClickListener
import ua.makuta.storylog.model.ModelVersion
import ua.makuta.storylog.utils.Utils.ARGS_TITLE
import ua.makuta.storylog.utils.Utils.ARGS_TYPE
import ua.makuta.storylog.utils.Utils.load

class FList: CoreFragment<FListBinding>(), OnItemClickListener<ModelVersion> {

    private val mainVM : MainViewModel by activityViewModels()
    private val appAdapter = AppAdapter(this)
    private var type = 0

    override fun onBinding(inflater: LayoutInflater, container: ViewGroup?) =
        FListBinding.inflate(inflater,container,false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listener.onHide()
        type = requireArguments().getInt(ARGS_TYPE,0)
        binding.title.text = requireArguments().getString(ARGS_TITLE,"")
        binding.list.apply {
            adapter = appAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
        binding.adView.load()
    }

    override fun onResume() {
        super.onResume()
        mainVM.arrData.observe(this) {
            if (!it.isNullOrEmpty()) {
                appAdapter.addAll(it)
            }
        }
    }

    override fun onStop() {
        super.onStop()
        appAdapter.clear()
        mainVM.arrData.removeObservers(this)
    }

    override fun onItemClick(item: ModelVersion) {
        mainVM.item.postValue(item)
    }
}
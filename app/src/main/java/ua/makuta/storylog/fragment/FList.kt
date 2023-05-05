package ua.makuta.storylog.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.OnScrollListener
import ua.makuta.storylog.R
import ua.makuta.storylog.activity.MainViewModel
import ua.makuta.storylog.adapter.VersionAdapter
import ua.makuta.storylog.core.CoreFragment
import ua.makuta.storylog.databinding.FListBinding
import ua.makuta.storylog.listeners.OnItemClickListener
import ua.makuta.storylog.model.ModelVersion
import ua.makuta.storylog.utils.Utils.ARGS_TITLE
import ua.makuta.storylog.utils.Utils.ARGS_TYPE
import ua.makuta.storylog.utils.Utils.gone
import ua.makuta.storylog.utils.Utils.visible

class FList: CoreFragment<FListBinding>(), OnItemClickListener<ModelVersion> {

    private val mainVM : MainViewModel by activityViewModels()
    private val versionAdapter = VersionAdapter(this)
    private val headers = arrayListOf<Int>()
    private var type = 0
    private var curr = -1
    private var title = ""

    override fun onBinding(inflater: LayoutInflater, container: ViewGroup?) =
        FListBinding.inflate(inflater,container,false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listener.onHide()
        type = requireArguments().getInt(ARGS_TYPE,0)
        title = requireArguments().getString(ARGS_TITLE,"")
        binding.title.title = title
        binding.list.apply {
            adapter = versionAdapter
            layoutManager = LinearLayoutManager(requireContext())
            binding.list. addOnScrollListener(object : OnScrollListener(){
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    val p = (recyclerView.layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()
                    if(p in 0 .. versionAdapter.itemCount){
                        if(p == 0 && headers.isNotEmpty()){
                            binding.title.gone()
                        }else{
                            binding.title.visible()
                        }
                        val item = versionAdapter[p]
                        if(item.isHeader()) {
                            curr = p
                            title = item.version
                        }else{
                            if(headers.isNotEmpty()) {
                                splitter(p)
                                title = versionAdapter[curr].version
                            }
                        }
                    }
                    binding.title.title = title
                }
            })
        }
    }

    private fun splitter(p : Int){
        for (h in 0 until headers.size) {
            curr = if (p > headers[h]) {
                headers[h]
            } else {
                headers[h - 1]
            }
        }
    }

    override fun onResume() {
        super.onResume()
        mainVM.arrData.observe(this) {
            if (!it.isNullOrEmpty()) {
                versionAdapter.addAll(it)
                for(i in 0 until it.size){
                    val item = it[i]
                    if(item.isHeader()){
                        headers.add(i)
                    }
                }
            }
        }
    }

    override fun onStop() {
        super.onStop()
        versionAdapter.clear()
        headers.clear()
        mainVM.arrData.removeObservers(this)
    }

    override fun onItemClick(item: ModelVersion) {
        if(headers.isNotEmpty()) {
            val p = versionAdapter.indexOf(item)
            splitter(p)
            title = versionAdapter[curr].version
        }
        mainVM.item.postValue(item)
        findNavController().navigate(
            R.id.action_FList_to_FInfo,
            bundleOf(ARGS_TITLE to title)
        )
    }
}
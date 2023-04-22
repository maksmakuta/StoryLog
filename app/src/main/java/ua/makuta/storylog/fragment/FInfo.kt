package ua.makuta.storylog.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import ua.makuta.storylog.activity.MainViewModel
import ua.makuta.storylog.adapter.DetailsAdapter
import ua.makuta.storylog.core.CoreFragment
import ua.makuta.storylog.databinding.FInfoBinding
import ua.makuta.storylog.utils.Utils.ARGS_TITLE
import ua.makuta.storylog.utils.Utils.gone
import ua.makuta.storylog.utils.Utils.load
import ua.makuta.storylog.utils.Utils.markdown

class FInfo : CoreFragment<FInfoBinding>() {

    private val mainVM : MainViewModel by activityViewModels()
    private val detailsAdapter = DetailsAdapter()
    private var title = ""

    override fun onBinding(inflater: LayoutInflater, container: ViewGroup?) =
        FInfoBinding.inflate(inflater,container,false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listener.onHide()
        title = requireArguments().getString(ARGS_TITLE,"")
        binding.featuresList.apply {
            adapter = detailsAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
        binding.adView.load()
    }

    @SuppressLint("SetTextI18n")
    override fun onResume() {
        super.onResume()
        mainVM.item.observe(this) {
            if (it != null) {
                binding.title.text = "$title ${it.version}"
                binding.text.markdown(it.logs)
                if(it.args.isNotEmpty()) {
                    detailsAdapter.clear()
                    val tmp = arrayListOf<Pair<String, String>>()
                    it.args.map { item -> Pair(item.key, item.value) }.toCollection(tmp)
                    detailsAdapter.addAll(tmp)
                }else{
                    binding.details.gone()
                    binding.featuresList.gone()
                }
            }
        }
    }

    override fun onStop() {
        super.onStop()
        mainVM.item.removeObservers(this)
        mainVM.item.value = null
        detailsAdapter.clear()
    }

}
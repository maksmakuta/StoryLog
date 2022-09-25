package ua.makuta.storylog.fragment.wearOS

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.progressindicator.CircularProgressIndicator
import ua.makuta.storylog.R
import ua.makuta.storylog.Utils.invisible
import ua.makuta.storylog.Utils.snack
import ua.makuta.storylog.Utils.visible
import ua.makuta.storylog.adapter.ModelAdapter
import ua.makuta.storylog.core.CoreFragment
import ua.makuta.storylog.enum.OS
import ua.makuta.storylog.listener.ItemClickListener
import ua.makuta.storylog.model.Model

class FWear: CoreFragment(), FWearContract.IView, ItemClickListener {

    private lateinit var presenter: FWearPresenter

    private lateinit var recycler: RecyclerView
    private lateinit var loader: CircularProgressIndicator
    private lateinit var title : TextView

    private lateinit var adapter: ModelAdapter
    private val models = ArrayList<Model>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        presenter = FWearPresenter(this)
        return inflater.inflate(R.layout.list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recycler = view.findViewById(R.id.list)
        loader = view.findViewById(R.id.loader)

        title = view.findViewById(R.id.title)
        title.text = getString(R.string.wear_os)

        showLoader()
        presenter.onLoad()
    }

    override fun onLoadSuccess(data: ArrayList<Model>) {
        if(isAdded) {
            requireActivity().runOnUiThread {
                models.clear()
                adapter = ModelAdapter(this, OS.WEAR_OS)
                adapter.update(data)
                models.addAll(data)

                recycler.adapter = adapter
                recycler.layoutManager = LinearLayoutManager(requireContext())
                hideLoader()
            }
        }
    }

    override fun onLoadFailed(msg: String) {
        if(isAdded) {
            requireActivity().runOnUiThread {
                requireView().snack(msg)
                hideLoader()
            }
        }
    }

    override fun showLoader() {
        if(isAdded) {
            requireActivity().runOnUiThread {
                recycler.invisible()
                loader.visible()
            }
        }
    }

    override fun hideLoader() {
        requireActivity().runOnUiThread {
            recycler.visible()
            loader.invisible()
        }
    }

    private fun checkOld(item: Model) : Boolean{
        val middle = models.indexOfFirst { it -> it.api == 1 }
        val pos = models.indexOf(item)
        return pos < middle
    }

    override fun onItemClick(item: Model) {
        if(isAdded) {
            val isOld = checkOld(item)
            findNavController().navigate(
                R.id.action_FWear_to_FInfo,
                bundleOf(
                    Pair("model", item),
                    Pair("type", 2),
                    Pair("old",isOld)
                )
            )
        }
    }
}
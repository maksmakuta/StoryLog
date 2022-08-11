package ua.makuta.storylog.fragment.ios

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
import ua.makuta.storylog.listener.ItemClickListener
import ua.makuta.storylog.model.Model

class FIos : CoreFragment(),FIosContract.IView, ItemClickListener {

    private lateinit var presenter: FIosPresenter

    private lateinit var recycler: RecyclerView
    private lateinit var loader: CircularProgressIndicator
    private lateinit var title : TextView

    private lateinit var adapter: ModelAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        presenter = FIosPresenter(this)
        return inflater.inflate(R.layout.list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recycler = view.findViewById(R.id.list)
        loader = view.findViewById(R.id.loader)

        title = view.findViewById(R.id.title)
        title.text = getString(R.string.ios)

        showLoader()
        presenter.onLoad()
    }

    override fun onLoadSuccess(data: ArrayList<Model>) {
        requireActivity().runOnUiThread {
            adapter = ModelAdapter(this,true)
            adapter.update(data)

            recycler.adapter = adapter
            recycler.layoutManager = LinearLayoutManager(requireContext())
            hideLoader()
        }
    }

    override fun onLoadFailed(msg: String) {
        requireActivity().runOnUiThread {
            requireView().snack(msg)
            hideLoader()
        }
    }

    override fun showLoader() {
        requireActivity().runOnUiThread {
            recycler.invisible()
            loader.visible()
        }
    }

    override fun hideLoader() {
        requireActivity().runOnUiThread {
            recycler.visible()
            loader.invisible()
        }
    }

    override fun onItemClick(item: Model) {
        findNavController().navigate(R.id.action_FIos_to_FInfo,
            bundleOf(
                Pair("model",item),
                Pair("type", false)
            )
        )
    }
}
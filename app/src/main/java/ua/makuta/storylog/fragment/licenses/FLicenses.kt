package ua.makuta.storylog.fragment.licenses

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.progressindicator.CircularProgressIndicator
import com.mikepenz.aboutlibraries.Libs
import com.mikepenz.aboutlibraries.util.withJson
import ua.makuta.storylog.R
import ua.makuta.storylog.Utils.invisible
import ua.makuta.storylog.Utils.visible
import ua.makuta.storylog.adapter.LibraryAdapter
import ua.makuta.storylog.core.CoreFragment
import ua.makuta.storylog.listener.NavBarListener

class FLicenses : CoreFragment() {

    private lateinit var listener: NavBarListener

    private lateinit var recycler : RecyclerView
    private lateinit var loader : CircularProgressIndicator

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.list, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recycler = view.findViewById(R.id.list)
        loader = view.findViewById(R.id.loader)

        listener.onHide()

        onHide()
        onLoad()
    }

    private fun onLoad(){
        val l = Libs.Builder().withJson(requireContext(),R.raw.aboutlibraries).build()
        val adapter = LibraryAdapter()
        adapter.update(l.libraries.toCollection(ArrayList()))
        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(requireContext())
        onShow()
    }

    private fun onShow(){
        recycler.visible()
        loader.invisible()
    }

    private fun onHide(){
        recycler.invisible()
        loader.visible()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = try{
            context as NavBarListener
        }catch (e : Exception){
            throw ClassCastException("NavBarListener")
        }
    }

}
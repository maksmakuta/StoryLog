package ua.makuta.storylog.fragment.wellcome

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.navigation.fragment.findNavController
import ua.makuta.storylog.R
import ua.makuta.storylog.core.CoreFragment
import ua.makuta.storylog.listener.NavBarListener
import java.lang.ClassCastException
import java.lang.Exception

class FWellcome : CoreFragment() {

    private lateinit var listener: NavBarListener
    private lateinit var info : CardView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_wellcome, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        info = view.findViewById(R.id.view_card)
        info.setOnClickListener {
            findNavController().navigate(R.id.action_FWellcome_to_FLicenses)
        }
    }

    override fun onResume() {
        super.onResume()
        listener.onShow()
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
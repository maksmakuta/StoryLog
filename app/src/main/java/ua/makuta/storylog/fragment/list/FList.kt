package ua.makuta.storylog.fragment.list

import android.view.LayoutInflater
import android.view.ViewGroup
import ua.makuta.storylog.core.CoreFragment
import ua.makuta.storylog.databinding.FListBinding

class FList: CoreFragment<FListBinding>() {

    override fun onBinding(inflater: LayoutInflater, container: ViewGroup?) =
        FListBinding.inflate(inflater,container,false)

}
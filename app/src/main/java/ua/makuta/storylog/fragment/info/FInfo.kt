package ua.makuta.storylog.fragment.info

import android.view.LayoutInflater
import android.view.ViewGroup
import ua.makuta.storylog.core.CoreFragment
import ua.makuta.storylog.databinding.FInfoBinding

class FInfo : CoreFragment<FInfoBinding>() {

    override fun onBinding(inflater: LayoutInflater, container: ViewGroup?) =
        FInfoBinding.inflate(inflater,container,false)

}
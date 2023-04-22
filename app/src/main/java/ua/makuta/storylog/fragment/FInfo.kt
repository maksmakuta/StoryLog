package ua.makuta.storylog.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ua.makuta.storylog.core.CoreFragment
import ua.makuta.storylog.databinding.FInfoBinding
import ua.makuta.storylog.utils.Utils.load

class FInfo : CoreFragment<FInfoBinding>() {

    override fun onBinding(inflater: LayoutInflater, container: ViewGroup?) =
        FInfoBinding.inflate(inflater,container,false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listener.onHide()
        binding.adView.load()
    }

}
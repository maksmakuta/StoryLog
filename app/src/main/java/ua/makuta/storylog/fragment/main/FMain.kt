package ua.makuta.storylog.fragment.main

import android.view.LayoutInflater
import android.view.ViewGroup
import ua.makuta.storylog.core.CoreFragment
import ua.makuta.storylog.databinding.FMainBinding

class FMain : CoreFragment<FMainBinding>() {

    override fun onBinding(inflater: LayoutInflater, container: ViewGroup?) =
        FMainBinding.inflate(inflater,container,false)
}
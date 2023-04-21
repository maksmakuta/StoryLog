package ua.makuta.storylog.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import ua.makuta.storylog.core.CoreAdapter
import ua.makuta.storylog.databinding.IVersionBinding
import ua.makuta.storylog.model.ModelApp

class AppAdapter : CoreAdapter<ModelApp,IVersionBinding>() {

    override fun onCreate(
        inflater: LayoutInflater,
        parent: ViewGroup,
        viewType: Int
    ) = IVersionBinding.inflate(inflater,parent,false)

    override fun onBind(binding: IVersionBinding, item: ModelApp) {
        binding.textVersion.text = item.version
    }

}
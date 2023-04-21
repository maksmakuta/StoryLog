package ua.makuta.storylog.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import ua.makuta.storylog.core.CoreAdapter
import ua.makuta.storylog.databinding.IVersionBinding
import ua.makuta.storylog.model.ModelOS

class VersionAdapter : CoreAdapter<ModelOS,IVersionBinding>() {

    override fun onCreate(
        inflater: LayoutInflater,
        parent: ViewGroup,
        viewType: Int
    ) = IVersionBinding.inflate(inflater,parent,false)

    override fun onBind(binding: IVersionBinding, item: ModelOS) {
        binding.textVersion.text = item.version
    }
}
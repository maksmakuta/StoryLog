package ua.makuta.storylog.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import ua.makuta.storylog.core.CoreAdapter
import ua.makuta.storylog.databinding.IDetailBinding

class DetailsAdapter : CoreAdapter<Pair<String,String>,IDetailBinding>() {

    override fun onCreate(
        inflater: LayoutInflater,
        parent: ViewGroup,
        viewType: Int
    )= IDetailBinding.inflate(inflater,parent,false)

    override fun onBind(binding: IDetailBinding, item: Pair<String, String>) {
        binding.first.text = item.first
        binding.second.text = item.second
    }
}
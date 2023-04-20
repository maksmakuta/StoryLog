package ua.makuta.storylog.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import coil.load
import ua.makuta.storylog.core.CoreAdapter
import ua.makuta.storylog.databinding.IItemBinding
import ua.makuta.storylog.model.ModelMenuItem

class MenuAdapter : CoreAdapter<ModelMenuItem,IItemBinding>() {

    override fun onCreate(
        inflater: LayoutInflater,
        parent: ViewGroup,
        viewType: Int
    ) = IItemBinding.inflate(inflater,parent,false)

    override fun onBind(binding: IItemBinding, item: ModelMenuItem) {
        if(item.icon.isNotEmpty())
            binding.projectIcon.load(item.icon)
        binding.projectTitle.text = item.title
        binding.projectDesc.text = item.desc
    }

}
package ua.makuta.storylog.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import coil.load
import ua.makuta.storylog.core.CoreAdapter
import ua.makuta.storylog.databinding.IItemBinding
import ua.makuta.storylog.listeners.OnItemClickListener
import ua.makuta.storylog.model.ModelMenuItem
import ua.makuta.storylog.net.BASE_URL

class MenuAdapter(
    private val listener : OnItemClickListener<ModelMenuItem>? = null
) : CoreAdapter<ModelMenuItem,IItemBinding>() {

    override fun onCreate(
        inflater: LayoutInflater,
        parent: ViewGroup,
        viewType: Int
    ) = IItemBinding.inflate(inflater,parent,false)

    override fun onBind(binding: IItemBinding, item: ModelMenuItem) {
        if(item.icon.isNotEmpty())
            binding.projectIcon.load("$BASE_URL${item.icon}")
        binding.projectTitle.text = item.title
        binding.projectDesc.text = item.desc
        binding.root.setOnClickListener{
            listener?.onItemClick(item)
        }
    }

}
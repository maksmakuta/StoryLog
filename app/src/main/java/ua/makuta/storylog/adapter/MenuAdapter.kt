package ua.makuta.storylog.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import coil.load
import ua.makuta.storylog.R
import ua.makuta.storylog.core.CoreAdapter
import ua.makuta.storylog.databinding.IItemBinding
import ua.makuta.storylog.listeners.OnItemClickListener
import ua.makuta.storylog.model.ModelMenuItem
import ua.makuta.storylog.net.BASE_URL
import ua.makuta.storylog.utils.Utils.ctx
import ua.makuta.storylog.utils.Utils.isDarkTheme

class MenuAdapter(
    private val listener : OnItemClickListener<ModelMenuItem>? = null
) : CoreAdapter<ModelMenuItem,IItemBinding>() {

    override fun onCreate(
        inflater: LayoutInflater,
        parent: ViewGroup,
        viewType: Int
    ) = IItemBinding.inflate(inflater,parent,false)

    override fun onBind(binding: IItemBinding, item: ModelMenuItem) {
        if(item.icon.isNotEmpty()) {
            item.icon.apply {
                if(size == 1){
                    if(this.first() == "app_icon"){
                        binding.projectIcon.load(R.mipmap.ic_launcher)
                    }else {
                        binding.projectIcon.load("$BASE_URL${this[0]}")
                    }
                }else{
                    if(!binding.ctx().isDarkTheme()){
                        binding.projectIcon.load("$BASE_URL${this[0]}")
                    }else{
                        binding.projectIcon.load("$BASE_URL${this[1]}")
                    }
                }
            }
        }
        binding.projectTitle.text = item.title
        binding.projectDesc.text = item.desc
        binding.root.setOnClickListener{
            listener?.onItemClick(item)
        }
    }

}
package ua.makuta.storylog.adapter

import android.view.Gravity
import android.view.LayoutInflater
import android.view.ViewGroup
import ua.makuta.storylog.core.CoreAdapter
import ua.makuta.storylog.databinding.IVersionBinding
import ua.makuta.storylog.listeners.OnItemClickListener
import ua.makuta.storylog.model.ModelVersion

class AppAdapter(
    private val listener : OnItemClickListener<ModelVersion>? = null
) : CoreAdapter<ModelVersion,IVersionBinding>() {

    override fun onCreate(
        inflater: LayoutInflater,
        parent: ViewGroup,
        viewType: Int
    ) = IVersionBinding.inflate(inflater,parent,false)

    override fun onBind(binding: IVersionBinding, item: ModelVersion) {
        binding.textVersion.text = item.version
        if(item.args.containsKey("header")){
            if(item.args["header"] == "true"){
                binding.textVersion.gravity = Gravity.CENTER
            }
        }else{
            binding.textVersion.gravity = Gravity.START
            binding.root.setOnClickListener{
                listener?.onItemClick(item)
            }
        }
    }

}
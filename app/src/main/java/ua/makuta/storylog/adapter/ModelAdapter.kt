package ua.makuta.storylog.adapter

import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import ua.makuta.storylog.R
import ua.makuta.storylog.Utils.invisible
import ua.makuta.storylog.Utils.visible
import ua.makuta.storylog.enum.OS
import ua.makuta.storylog.listener.ItemClickListener
import ua.makuta.storylog.model.Model

class ModelAdapter(private val listener: ItemClickListener,private val os : OS = OS.ANDROID) : RecyclerView.Adapter<ModelAdapter.Holder>() {

    private val data = ArrayList<Model>()

    fun update(models : ArrayList<Model>){
        data.clear()
        data.addAll(models)
        notifyItemRangeChanged(0,models.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false)
        return Holder(v)
    }

    override fun onBindViewHolder(holder: Holder, pos: Int) {
        holder.bind(data[pos],listener,os)
    }

    override fun getItemCount(): Int = data.size

    class Holder(val view: View) : RecyclerView.ViewHolder(view){

        val version : TextView = view.findViewById(R.id.item_ver)
        val name    : TextView = view.findViewById(R.id.item_name)
        val title   : TextView = view.findViewById(R.id.item_title)

        fun bind(model: Model,listener: ItemClickListener,os : OS){
            if(os == OS.IOS){
                name.invisible()
            }
            if(os == OS.WEAR_OS){
                if(model.api == 1){
                    version.invisible()
                    name.invisible()
                    title.visible()
                    view.findViewById<CardView>(R.id.card).cardElevation = 0.0f
                    title.setTextSize(TypedValue.COMPLEX_UNIT_SP, 24.0f)
                    title.text = model.version
                }else{
                    name.invisible()
                    version.text = model.version
                    view.setOnClickListener {
                        listener.onItemClick(model)
                    }
                }
            }else{
                version.text = model.version
                name.text = model.codename
                view.setOnClickListener {
                    listener.onItemClick(model)
                }
            }
        }
    }
}
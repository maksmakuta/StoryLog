package ua.mstudio.droid.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ua.mstudio.droid.R
import ua.mstudio.droid.model.DroidVersion

class VersionAdapter : RecyclerView.Adapter<VersionAdapter.Holder>() {

    private val data = ArrayList<DroidVersion>()

    fun update(items : ArrayList<DroidVersion>){
        data.clear()
        data.addAll(items)
        notifyItemRangeChanged(0,items.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_version,parent,false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.onBind(data[position])
    }

    override fun getItemCount(): Int = data.size

    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun onBind(model : DroidVersion){

        }

    }
}
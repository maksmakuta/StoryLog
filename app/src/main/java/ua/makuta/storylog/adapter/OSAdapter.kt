package ua.makuta.storylog.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ua.makuta.storylog.R
import ua.makuta.storylog.model.ModelOSItem

class OSAdapter : RecyclerView.Adapter<OSAdapter.Holder>() {

    private val data = ArrayList<ModelOSItem>()


    fun update(list: ArrayList<ModelOSItem>) {
        data.clear()
        data.addAll(list)
        notifyItemRangeChanged(0, list.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_os, parent, false)
        return Holder(v)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.onBind(data[position])
    }

    override fun getItemCount(): Int = data.size

    class Holder(val view: View) : RecyclerView.ViewHolder(view) {

        private val name: TextView = view.findViewById(R.id.os_name)
        private val logo: ImageView = view.findViewById(R.id.os_logo)

        fun onBind(item: ModelOSItem) {
            name.text = view.context.getString(item.name)
            logo.setImageResource(item.img)
        }

    }
}
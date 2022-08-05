package ua.makuta.storylog.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mikepenz.aboutlibraries.entity.Library
import ua.makuta.storylog.R

class LibraryAdapter : RecyclerView.Adapter<LibraryAdapter.Holder>() {

    private val data = ArrayList<Library>()

    fun update(libraries : ArrayList<Library>){
        data.clear()
        data.addAll(libraries)
        notifyItemRangeChanged(0,libraries.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_lib,parent,false)
        return Holder(v)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.onBind(data[position])
    }

    override fun getItemCount(): Int = data.size

    class Holder(val view : View) : RecyclerView.ViewHolder(view){

        private val name : TextView = view.findViewById(R.id.libraryName)
        private val devn : TextView = view.findViewById(R.id.libraryCreator)
        private val lver : TextView = view.findViewById(R.id.libraryVersion)
        private val llic : TextView = view.findViewById(R.id.libraryLicense)
        private val decs : TextView = view.findViewById(R.id.libraryDescription)

        fun onBind(item : Library){
            name.text = item.name
            if(item.developers.isNotEmpty())
                devn.text = item.developers.first().name
            lver.text = item.artifactVersion.toString()
            if(item.licenses.isNotEmpty())
                llic.text = item.licenses.first().name
            decs.text = item.description
        }

    }

}
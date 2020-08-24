package ua.mstudio.droid.data

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.Configuration
import android.graphics.Color
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.google.android.material.card.MaterialCardView
import ua.mstudio.droid.R
import ua.mstudio.droid.model.DroidVersion
import ua.mstudio.droid.model.initDroid

class DroidAdapter(ctx: Context) : RecyclerView.Adapter<DroidAdapter.DroidHolder>() {

    var context : Context = ctx
    lateinit var view : View
    var data : ArrayList<DroidVersion> = initDroid()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DroidHolder {
        view = LayoutInflater.from(context).inflate(R.layout.droid_view,parent,false)
        return DroidHolder(view,context)
    }

    override fun onBindViewHolder(holder: DroidHolder, position: Int) {
       holder.bind(data.get(position))
    }

    override fun getItemCount(): Int {
        return data.size
    }
    class DroidHolder(itemView: View,ctx : Context) : ViewHolder(itemView){

        var c : Context = ctx
        var root : MaterialCardView = itemView.findViewById(R.id.root)
        var droidName = itemView.findViewById<TextView>(R.id.name)
        var droidChar = itemView.findViewById<TextView>(R.id.suffix)
        var droidAPI = itemView.findViewById<TextView>(R.id.api)
        var droidDate = itemView.findViewById<TextView>(R.id.date)


        @SuppressLint("SetTextI18n", "ResourceAsColor", "ResourceType", "NewApi")
        fun bind(item : DroidVersion){
            droidName.text = item.name
            droidChar.text = item.prefix
            droidAPI.text = "API level : " + item.apiLevel.toString()
            droidDate.text = "Published at " + item.stableDate
            if(item.apiLevel == Build.VERSION.SDK_INT){
                root.setCardBackgroundColor(Color.CYAN)
                setTextColor(Color.BLACK)
            }else {
                root.setCardBackgroundColor(Color.TRANSPARENT)
                if (c.resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
                    == Configuration.UI_MODE_NIGHT_YES
                ){
                    setTextColor(Color.WHITE)
                } else {
                    setTextColor(Color.BLACK)
                }
            }
        }

        fun setTextColor(color : Int){
            droidName.setTextColor(color)
            droidChar.setTextColor(color)
            droidAPI.setTextColor(color)
            droidDate.setTextColor(color)
        }
    }

}

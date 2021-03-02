package ua.mstudio.droid.data

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.Configuration
import android.graphics.Color
import android.os.Build
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView
import ua.mstudio.droid.R
import ua.mstudio.droid.interfaces.OnRecyclerItemClick
import ua.mstudio.droid.models.DroidVersion
import ua.mstudio.droid.utils.isDarkTheme

class DroidHolder(context: Context, itemView: View) : RecyclerView.ViewHolder(itemView){

    private var root : MaterialCardView = itemView.findViewById(R.id.item_root)
    private val name : TextView = itemView.findViewById(R.id.droidCN)
    private val ver : TextView = itemView.findViewById(R.id.droidV)
    private var ctx = context

    @SuppressLint("ResourceAsColor")
    fun bind(i: DroidVersion,onItemClickListener : OnRecyclerItemClick){
        name.text = i.name
        ver.text = i.version

        if(i.api == Build.VERSION.SDK_INT && i.version == Build.VERSION.RELEASE){
            if(isDarkTheme(ctx))
                root.setCardBackgroundColor(Color.DKGRAY)
            else
                root.setCardBackgroundColor(ContextCompat.getColor(ctx, R.color.primary))
            setTextColor(Color.BLACK)
        }else {
            if (isDarkTheme(ctx)){
                root.setCardBackgroundColor(Color.BLACK)
                setTextColor(Color.WHITE)
            } else {
                root.setCardBackgroundColor(Color.WHITE)
                setTextColor(Color.BLACK)
            }
        }

        itemView.setOnClickListener {
            onItemClickListener.onItemClick(i)
        }

    }
    private fun setTextColor(color: Int){
        name.setTextColor(color)
        ver.setTextColor(color)
    }
}
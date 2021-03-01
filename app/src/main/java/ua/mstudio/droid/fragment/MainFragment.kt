package ua.mstudio.droid.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ua.mstudio.droid.R
import ua.mstudio.droid.data.DroidAdapter
import ua.mstudio.droid.models.DroidVersion


class MainFragment(context: Context,droidVersionArray : ArrayList<DroidVersion>) : Fragment() {

    lateinit var rView : RecyclerView
    var ctx = context
    var data = droidVersionArray

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view : View = inflater.inflate(R.layout.main_fragment, container, false)
        rView = view.findViewById(R.id.droidList)
        rView.layoutManager = LinearLayoutManager(ctx)
        rView.adapter = DroidAdapter(data, ctx)
        return view
    }


}
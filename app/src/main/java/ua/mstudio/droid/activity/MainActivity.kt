package ua.mstudio.droid.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ua.mstudio.droid.R
import ua.mstudio.droid.data.DroidAdapter
import ua.mstudio.droid.interfaces.OnRecyclerItemClick
import ua.mstudio.droid.models.DroidVersion
import ua.mstudio.droid.utils.GsonUtils
import ua.mstudio.droid.utils.ThemeUtils

class MainActivity : AppCompatActivity(),OnRecyclerItemClick{

    lateinit var droidList: RecyclerView
    lateinit var mainData : ArrayList<DroidVersion>

    override fun onCreate(savedInstanceState: Bundle?) {
        ThemeUtils().draw(this)
        mainData = GsonUtils().loadData(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        droidList = findViewById(R.id.droidList)
        droidList.layoutManager = LinearLayoutManager(this)
        droidList.adapter = DroidAdapter(mainData,this,this)
    }



    override fun onItemClick(obj: DroidVersion) {
        val intent = Intent(this,InfoActivity::class.java)
        intent.putExtra("version",obj)
        startActivity(intent)
    }

}
package ua.mstudio.droid.activity

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
import ua.mstudio.droid.R
import ua.mstudio.droid.data.DroidAdapter
import ua.mstudio.droid.interfaces.OnRecyclerItemClick
import ua.mstudio.droid.models.DroidVersion
import ua.mstudio.droid.utils.GsonUtils
import ua.mstudio.droid.utils.isDarkTheme

class MainActivity : AppCompatActivity(),OnRecyclerItemClick{

    lateinit var droidList: RecyclerView
    lateinit var mainData : ArrayList<DroidVersion>

    override fun onCreate(savedInstanceState: Bundle?) {
        draw()
        mainData = GsonUtils().loadData(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        droidList = findViewById(R.id.droidList)
        droidList.layoutManager = LinearLayoutManager(this)
        droidList.adapter = DroidAdapter(mainData,this,this)
    }

    private fun draw(){
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        if(isDarkTheme(this))
            window.statusBarColor = Color.BLACK
    }

    override fun onItemClick(obj: DroidVersion) {
        val intent = Intent(this,InfoActivity::class.java)
        intent.putExtra("version",obj)
        startActivity(intent)
    }

}
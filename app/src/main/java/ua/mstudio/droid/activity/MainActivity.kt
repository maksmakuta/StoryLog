package ua.mstudio.droid.activity

import android.graphics.Color
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ua.mstudio.droid.R
import ua.mstudio.droid.data.DroidAdapter
import ua.mstudio.droid.models.DroidVersion
import ua.mstudio.droid.utils.isDarkTheme

class MainActivity : AppCompatActivity(){

    lateinit var rView : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        draw()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rView = findViewById(R.id.list)
        rView.layoutManager = LinearLayoutManager(this)
        rView.adapter = DroidAdapter(ArrayList<DroidVersion>(), this)
    }

    private fun draw(){
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        if(isDarkTheme(this))
            window.statusBarColor = Color.BLACK

    }
}
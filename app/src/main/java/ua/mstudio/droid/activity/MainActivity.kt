package ua.mstudio.droid.activity

import android.graphics.Color
import android.os.Bundle
import android.view.WindowManager
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import ua.mstudio.droid.R
import ua.mstudio.droid.utils.isDarkTheme

class MainActivity : AppCompatActivity(){

    lateinit var mainFrame : FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        draw()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainFrame = findViewById(R.id.mainFrame)
    }

    private fun draw(){
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        if(isDarkTheme(this))
            window.statusBarColor = Color.BLACK

    }
}
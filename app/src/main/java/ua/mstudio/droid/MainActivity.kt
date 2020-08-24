package ua.mstudio.droid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ua.mstudio.droid.data.DroidAdapter

class MainActivity : AppCompatActivity() {

    lateinit var droidList : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        droidList = findViewById(R.id.list)
        droidList.adapter = DroidAdapter(this)
        droidList.layoutManager = LinearLayoutManager(this)
    }


}
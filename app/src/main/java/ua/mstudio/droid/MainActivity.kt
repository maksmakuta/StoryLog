package ua.mstudio.droid

import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetBehavior
import ua.mstudio.droid.data.DroidAdapter
import ua.mstudio.droid.data.callback.DroidCallback

class MainActivity : AppCompatActivity(){

    lateinit var droidList : RecyclerView
    lateinit var adapter : DroidAdapter
    lateinit var bottomSheet : LinearLayout
    lateinit var sheetBehavior : BottomSheetBehavior<LinearLayout>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        droidList = findViewById(R.id.list)
        bottomSheet = findViewById(R.id.bottom_sheet)
        sheetBehavior = BottomSheetBehavior.from(bottomSheet)
        adapter = DroidAdapter(this,sheetBehavior,bottomSheet)
        droidList.adapter = adapter
        droidList.layoutManager = LinearLayoutManager(this)
        val callback: ItemTouchHelper.Callback = DroidCallback(adapter)
        val touchHelper = ItemTouchHelper(callback)
        touchHelper.attachToRecyclerView(droidList)

    }

}
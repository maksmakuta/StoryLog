package ua.mstudio.droid.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textview.MaterialTextView
import ua.mstudio.droid.R
import ua.mstudio.droid.models.DroidStory
import ua.mstudio.droid.models.DroidVersion
import ua.mstudio.droid.utils.GsonUtils
import ua.mstudio.droid.utils.ThemeUtils

class InfoActivity : AppCompatActivity() {

    private lateinit var version : DroidVersion
    private lateinit var story   : DroidStory
    private lateinit var droidVersion   : MaterialTextView
    private lateinit var droidAPI       : MaterialTextView
    private lateinit var droidDate      : MaterialTextView
    private lateinit var droidChangelog : MaterialTextView

    override fun onCreate(savedInstanceState: Bundle?) {
        ThemeUtils().draw(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.info_activity)

        version = intent.getSerializableExtra("version") as DroidVersion
        story   = version.let { GsonUtils().loadStory(this, it) }

        droidVersion   = findViewById(R.id.info_version)
        droidAPI       = findViewById(R.id.info_api)
        droidDate      = findViewById(R.id.info_date)
        droidChangelog = findViewById(R.id.info_changelog)

        droidVersion  .text = createAndroidString(version.version)
        droidAPI      .text = createAPIString(version.api)
        droidDate     .text = story.date
        droidChangelog.text = story.changelog
    }

    private fun createAPIString(api :Int): String{
        return "API level : $api"
    }

    private fun createAndroidString(v : String) : String{
        return "Android $v"
    }

}

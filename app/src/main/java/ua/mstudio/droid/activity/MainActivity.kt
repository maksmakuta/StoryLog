package ua.mstudio.droid.activity

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.Configuration
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.getColor
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import ua.mstudio.droid.R
import ua.mstudio.droid.models.DroidStory
import ua.mstudio.droid.models.DroidVersion
import ua.mstudio.droid.utils.isDarkTheme

class MainActivity : AppCompatActivity(){
    lateinit var rView : RecyclerView
    lateinit var str : DroidStory
    override fun onCreate(savedInstanceState: Bundle?) {
        draw()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rView = findViewById(R.id.list)
        rView.layoutManager = LinearLayoutManager(this)
        rView.adapter = DroidAdapter(data(), this)
        str = DroidStory(100,"September 23, 2008",
            "Android Market, allowing application downloads and updates through the Market application.\n" +
                    "Web browser to show, zoom and pan full HTML and XHTML web pages – multiple pages show as windows (\"cards\").[38][39]\n" +
                    "Camera support – however, this version lacked the option to change the camera's resolution, white balance, quality, etc.[40]\n" +
                    "Folders allowing the grouping of a number of application icons into a single folder icon on the Home screen.[41]\n" +
                    "Access to web email servers, supporting POP3, IMAP4, and SMTP.[39]\n" +
                    "Gmail synchronization with the Gmail application.\n" +
                    "Google Contacts synchronization with the People application.\n" +
                    "Google Calendar synchronization with the Calendar application.\n" +
                    "Google Maps with Street View to view maps and satellite imagery, as well as find local businesses and obtain driving directions using GPS.[40]\n" +
                    "Google Sync, allowing management of over-the-air synchronization of Gmail, People, and Calendar.\n" +
                    "Google Search, allowing users to search the Internet and phone applications, contacts, calendar, etc.\n" +
                    "Google Talk instant messaging.\n" +
                    "Instant messaging, text messaging, and MMS.\n" +
                    "Media Player, enabling management, importing, and playback of media files – however, this version lacked video and stereo Bluetooth support.[39][40]\n" +
                    "Notifications appear in the Status bar, with options to set ringtone, LED or vibration alerts.[38][39][42]\n" +
                    "Voice Dialer allows dialing and placing of phone calls without typing a name or number.[39]\n" +
                    "Wallpaper allows the user to set the background image or photo behind the Home screen icons and widgets.\n" +
                    "YouTube video player.[43]\n" +
                    "Other applications include: Alarm Clock, Calculator, Dialer (Phone), Home screen (Launcher), Pictures (Gallery), and Settings.\n" +
                    "Wi-Fi and Bluetooth support."
            )
        val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
        val jsonAdapter: JsonAdapter<DroidStory> = moshi.adapter(DroidStory::class.java)

        val json = jsonAdapter.toJson(str)
        println(json)

    }
    class DroidAdapter(list: ArrayList<DroidVersion>, context: Context) : RecyclerView.Adapter<DroidAdapter.DroidHolder>(){
        val data = list
        val ctx = context
        inner class DroidHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
            var root : MaterialCardView = itemView.findViewById(R.id.item_root)
            val name : TextView = itemView.findViewById(R.id.droidCN)
            val ver : TextView = itemView.findViewById(R.id.droidV)
            @SuppressLint("ResourceAsColor")
            fun bind(i: DroidVersion){
                name.text = i.CodeName
                ver.text = i.CodeVersion

                if(i.api == Build.VERSION.SDK_INT){
                    if(isDarkTheme(ctx))
                        root.setCardBackgroundColor(Color.DKGRAY)
                    else
                        root.setCardBackgroundColor(getColor(ctx,R.color.primary))
                    setTextColor(Color.BLACK)
                }else {
                    if (ctx.resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK == Configuration.UI_MODE_NIGHT_YES){
                        root.setCardBackgroundColor(Color.BLACK)
                        setTextColor(Color.WHITE)
                    } else {
                        root.setCardBackgroundColor(Color.WHITE)
                        setTextColor(Color.BLACK)
                    }
                }
            }
            fun setTextColor(color: Int){
                name.setTextColor(color)
                ver.setTextColor(color)
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DroidHolder {
            val view = LayoutInflater.from(ctx).inflate(R.layout.list_view, parent, false)
            return DroidHolder(view)
        }

        override fun onBindViewHolder(holder: DroidHolder, position: Int) {
                holder.bind(data[position])
        }

        override fun getItemCount(): Int {
            return data.size
        }

    }


    fun draw(){
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        if(isDarkTheme(this))
            window.statusBarColor = Color.BLACK

    }

    fun data() : ArrayList<DroidVersion> {
        return arrayListOf(
            DroidVersion(1, "A", "1.0"),
            DroidVersion(2, "B", "1.1"),
            DroidVersion(3, "Cupcake", "1.5"),
            DroidVersion(4, "Donut", "1.6"),
            DroidVersion(5, "Eclair", "2.0"),
            DroidVersion(6, "Eclair", "2.0.1"),
            DroidVersion(7, "Eclair", "2.1"),
            DroidVersion(8, "Froyo", "2.2"),
            DroidVersion(8, "Froyo", "2.2.1"),
            DroidVersion(8, "Froyo", "2.2.2"),
            DroidVersion(8, "Froyo", "2.2.3"),
            DroidVersion(9, "Gingerbread", "2.3"),
            DroidVersion(9, "Gingerbread", "2.3.1"),
            DroidVersion(9, "Gingerbread", "2.3.2"),
            DroidVersion(10, "Gingerbread", "2.3.3"),
            DroidVersion(10, "Gingerbread", "2.3.4"),
            DroidVersion(10, "Gingerbread", "2.3.5"),
            DroidVersion(10, "Gingerbread", "2.3.6"),
            DroidVersion(10, "Gingerbread", "2.3.7"),
            DroidVersion(11, "Honeycomb", "3.0"),
            DroidVersion(12, "Honeycomb", "3.1"),
            DroidVersion(13, "Honeycomb", "3.2"),
            DroidVersion(13, "Honeycomb", "3.2.1"),
            DroidVersion(13, "Honeycomb", "3.2.2"),
            DroidVersion(13, "Honeycomb", "3.2.3"),
            DroidVersion(13, "Honeycomb", "3.2.4"),
            DroidVersion(13, "Honeycomb", "3.2.5"),
            DroidVersion(13, "Honeycomb", "3.2.6"),
            DroidVersion(14, "Ice Cream Sandwich", "4.0"),
            DroidVersion(14, "Ice Cream Sandwich", "4.0.1"),
            DroidVersion(14, "Ice Cream Sandwich", "4.0.2"),
            DroidVersion(15, "Ice Cream Sandwich", "4.0.3"),
            DroidVersion(15, "Ice Cream Sandwich", "4.0.4"),
            DroidVersion(16, "Jelly Bean", "4.1"),
            DroidVersion(16, "Jelly Bean", "4.1.1"),
            DroidVersion(16, "Jelly Bean", "4.1.2"),
            DroidVersion(17, "Jelly Bean", "4.2"),
            DroidVersion(17, "Jelly Bean", "4.2.1"),
            DroidVersion(17, "Jelly Bean", "4.2.2"),
            DroidVersion(18, "Jelly Bean", "4.3"),
            DroidVersion(18, "Jelly Bean", "4.3.1"),
            DroidVersion(19, "KitKat", "4.4"),
            DroidVersion(19, "KitKat", "4.4.1"),
            DroidVersion(19, "KitKat", "4.4.2"),
            DroidVersion(19, "KitKat", "4.4.3"),
            DroidVersion(19, "KitKat", "4.4.4"),
            DroidVersion(21, "Lollipop", "5.0"),
            DroidVersion(21, "Lollipop", "5.0.1"),
            DroidVersion(21, "Lollipop", "5.0.2"),
            DroidVersion(22, "Lollipop", "5.1"),
            DroidVersion(22, "Lollipop", "5.1.1"),
            DroidVersion(23, "Marshmallow", "6.0"),
            DroidVersion(23, "Marshmallow", "6.0.1"),
            DroidVersion(24, "Nougat", "7.0"),
            DroidVersion(25, "Nougat", "7.1"),
            DroidVersion(25, "Nougat", "7.1.1"),
            DroidVersion(25, "Nougat", "7.1.2"),
            DroidVersion(26, "Oreo", "8.0"),
            DroidVersion(27, "Oreo", "8.1.0"),
            DroidVersion(28, "Pie", "9"),
            DroidVersion(29, "Q", "10"),
            DroidVersion(30, "R", "11")
        )
    }

}
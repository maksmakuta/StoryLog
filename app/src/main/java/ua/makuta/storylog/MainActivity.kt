package ua.makuta.storylog

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.navigation.findNavController
import com.google.android.gms.ads.MobileAds
import ua.makuta.storylog.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(){

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        MobileAds.initialize(this) {
            for((k,p) in it.adapterStatusMap)
                Log.i("ADB","$k -> $p")
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}
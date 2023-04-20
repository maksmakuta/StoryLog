package ua.makuta.storylog.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.google.android.gms.ads.MobileAds
import ua.makuta.storylog.R
import ua.makuta.storylog.databinding.AMainBinding
import ua.makuta.storylog.utils.Utils.load

class MainActivity : AppCompatActivity() {

    private val vm : MainViewModel by viewModels()
    private lateinit var binding: AMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = AMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        MobileAds.initialize(this) {
            binding.adView.load()
        }

        binding.navBar.setOnItemSelectedListener {
            when(it.itemId){
                R.id.menu_os -> {

                }
                R.id.menu_app -> {}
                R.id.menu_game -> {}
                else -> {}
            }
            true
        }

    }

    override fun onStart() {
        super.onStart()
        vm.loadMenu()
    }

    override fun onRestart() {
        super.onRestart()
        vm.data.observe(this){
            if(it != null){

            }
        }
    }

    override fun onStop() {
        super.onStop()
        vm.data.removeObservers(this)
        vm.data.value = null
    }

}
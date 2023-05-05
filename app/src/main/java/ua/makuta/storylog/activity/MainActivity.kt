package ua.makuta.storylog.activity

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.google.android.gms.ads.MobileAds
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import ua.makuta.storylog.R
import ua.makuta.storylog.databinding.AMainBinding
import ua.makuta.storylog.enums.DataType
import ua.makuta.storylog.listeners.OnNavigationListener
import ua.makuta.storylog.utils.Utils.ARGS_LIST
import ua.makuta.storylog.utils.Utils.gone
import ua.makuta.storylog.utils.Utils.load
import ua.makuta.storylog.utils.Utils.visible

class MainActivity : AppCompatActivity(), OnNavigationListener {

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
        navController.setGraph(R.navigation.nav_graph,bundleOf(ARGS_LIST to 0))
        MobileAds.initialize(this) {
            binding.adView.load()
        }
        binding.navBar.setOnItemSelectedListener {
            when(it.itemId){
                R.id.menu_os -> {
                    navController.navigate(R.id.FMain, bundleOf(ARGS_LIST to DataType.OS.ordinal))
                }
                R.id.menu_app -> {
                    navController.navigate(R.id.FMain, bundleOf(ARGS_LIST to DataType.APP.ordinal))
                }
                R.id.menu_game -> {
                    navController.navigate(R.id.FMain, bundleOf(ARGS_LIST to DataType.GAME.ordinal))
                }
                else -> {}
            }
            true
        }
        vm.checkNetwork()
    }

    override fun onStart() {
        super.onStart()
        vm.hasInternet.observe(this){
            if(it != null){
                if(it){
                    vm.loadMenu()
                }else{
                    MaterialAlertDialogBuilder(this)
                        .setCancelable(false)
                        .setTitle(R.string.no_internet)
                        .setMessage(R.string.no_internet_msg)
                        .setPositiveButton(android.R.string.ok){d,_ ->
                            finish()
                            d.dismiss()
                        }
                        .show()
                }
            }
        }
    }

    override fun onStop() {
        super.onStop()
        vm.data.removeObservers(this)
        vm.data.value = null
    }

    override fun onHide() {
        runOnUiThread {
            binding.navBar.gone()
        }
    }

    override fun onShow() {
        runOnUiThread {
            binding.navBar.visible()
        }
    }

    override fun onView(): View = binding.navBar

}
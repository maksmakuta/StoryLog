package ua.makuta.storylog

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import ua.makuta.storylog.Utils.invisible
import ua.makuta.storylog.Utils.visible
import ua.makuta.storylog.databinding.ActivityMainBinding
import ua.makuta.storylog.listener.NavBarListener

class MainActivity : AppCompatActivity(),NavBarListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navBar : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navBar = binding.nav
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        navBar.setupWithNavController(navController)

        navBar.setOnItemSelectedListener {
            navController.navigate(it.itemId)
            navController.popBackStack(it.itemId,false)
            true
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    override fun onShow() {
        navBar.visible()
    }

    override fun onHide() {
        navBar.invisible()
    }
}
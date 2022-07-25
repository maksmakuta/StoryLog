package ua.mstudio.droid.activity

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import ua.mstudio.droid.R
import ua.mstudio.droid.core.CoreFragment
import ua.mstudio.droid.fragments.droid_list.FList

class MainActivity : AppCompatActivity(), MainContract.IView {

    private lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        presenter = MainPresenter(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.checkConnection(this)
    }

    private fun setFragment(fragment : CoreFragment){
        supportFragmentManager.commit{
            replace(R.id.container,fragment)
            setCustomAnimations(android.R.anim.fade_in,android.R.anim.fade_out)
        }
    }

    override fun connectionExist(hasConnection: Boolean) {
        if(hasConnection){
            val listFragment = FList()
            setFragment(listFragment)
        }else{
            AlertDialog.Builder(this)
                .setMessage(R.string.connect_message)
                .setCancelable(false)
                .setPositiveButton(R.string.exit){dialog,_ ->
                    dialog.dismiss()
                    finishAffinity()
                }
                .show()
        }
    }
}
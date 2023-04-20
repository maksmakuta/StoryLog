package ua.makuta.storylog.fragment.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import ua.makuta.storylog.activity.MainViewModel
import ua.makuta.storylog.adapter.MenuAdapter
import ua.makuta.storylog.core.CoreFragment
import ua.makuta.storylog.databinding.FMainBinding
import ua.makuta.storylog.enums.DataType
import ua.makuta.storylog.utils.Utils

class FMain : CoreFragment<FMainBinding>() {

    private val mainVM : MainViewModel by activityViewModels()
    private val menuAdapter = MenuAdapter()
    private var type = 0

    override fun onBinding(inflater: LayoutInflater, container: ViewGroup?) =
        FMainBinding.inflate(inflater,container,false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(!requireArguments().isEmpty)
            type = requireArguments().getInt(Utils.ARGS_LIST,0)
        binding.itemsMenu.apply {
            adapter = menuAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    override fun onStart() {
        super.onStart()
        mainVM.data.observe(this){
            if(it != null){
                menuAdapter.addAll(
                    when(type){
                        DataType.OS.ordinal -> it.os
                        DataType.APP.ordinal -> it.app
                        DataType.GAME.ordinal -> it.game
                        else -> arrayListOf()
                    }
                )
            }
        }
    }

    override fun onStop() {
        super.onStop()
        menuAdapter.clear()
        mainVM.data.removeObservers(this)
    }

}

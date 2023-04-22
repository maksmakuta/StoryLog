package ua.makuta.storylog.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import ua.makuta.storylog.R
import ua.makuta.storylog.activity.MainViewModel
import ua.makuta.storylog.adapter.MenuAdapter
import ua.makuta.storylog.core.CoreFragment
import ua.makuta.storylog.databinding.FMainBinding
import ua.makuta.storylog.enums.DataType
import ua.makuta.storylog.listeners.OnItemClickListener
import ua.makuta.storylog.model.ModelMenuItem
import ua.makuta.storylog.utils.Utils
import ua.makuta.storylog.utils.Utils.ARGS_TITLE
import ua.makuta.storylog.utils.Utils.ARGS_TYPE
import ua.makuta.storylog.utils.Utils.snack

class FMain : CoreFragment<FMainBinding>(), OnItemClickListener<ModelMenuItem> {

    private val mainVM : MainViewModel by activityViewModels()
    private val menuAdapter = MenuAdapter(this)
    private var type = 0

    override fun onBinding(inflater: LayoutInflater, container: ViewGroup?) =
        FMainBinding.inflate(inflater,container,false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listener.onShow()
        if(!requireArguments().isEmpty)
            type = requireArguments().getInt(Utils.ARGS_LIST,0)
        binding.itemsMenu.apply {
            adapter = menuAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    override fun onStart() {
        super.onStart()
        mainVM.arrData.value = null
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

    override fun onItemClick(item: ModelMenuItem) {
        if(item.file.isNotEmpty()) {
            mainVM.loadFile(item.file)
            findNavController().navigate(
                R.id.action_FMain_to_FList,
                bundleOf(
                    ARGS_TITLE to item.title,
                    ARGS_TYPE to type
                )
            )
        }else{
            snack(R.string.error_no_file)
        }
    }

}

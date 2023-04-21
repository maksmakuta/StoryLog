package ua.makuta.storylog.core

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import ua.makuta.storylog.listeners.OnNavigationListener
import java.lang.Exception

abstract class CoreFragment<VB : ViewBinding> : Fragment(){

    private var _binding : VB? = null
    private var _listener : OnNavigationListener? = null
    lateinit var binding : VB
    lateinit var listener: OnNavigationListener

    abstract fun onBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) : VB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = onBinding(inflater,container)
        binding = _binding!!
        return _binding?.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        _listener = try {
            context as OnNavigationListener
        }catch (e : Exception){
            e.printStackTrace()
            null
        }

        if(_listener != null)
            listener = _listener!!
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
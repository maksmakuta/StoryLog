package ua.makuta.storylog.core

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class CoreFragment<VB : ViewBinding> : Fragment(){

    private var _binding : VB? = null
    lateinit var binding : VB

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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
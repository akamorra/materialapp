package com.groke.materialapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.groke.materialapp.databinding.PodmainFragmentBinding
import com.groke.materialapp.viewmodel.AppState
import com.groke.materialapp.viewmodel.MainViewModel

class PODMainFragment : Fragment() {
    private var _binding: PodmainFragmentBinding? = null
    private val binding get() = _binding!!

    @Override
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = PodmainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        val observerMainViewModel = Observer<AppState> { renderData(it) }
        mainViewModel.getData().observe(viewLifecycleOwner, observerMainViewModel)
        mainViewModel.getImage()
    }

    private fun renderData(data: AppState) {
        when (data) {
            AppState.Success -> Toast.makeText(requireContext(), "Success", Toast.LENGTH_SHORT)
                .show()
            is AppState.Error -> Toast.makeText(requireContext(), "Error", Toast.LENGTH_SHORT)
                .show()
            AppState.Loading -> Toast.makeText(requireContext(), "Loading", Toast.LENGTH_SHORT)
                .show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        @JvmStatic
        fun newInstance() = PODMainFragment()
    }
}
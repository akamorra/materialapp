package com.groke.materialapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.groke.materialapp.R
import com.groke.materialapp.databinding.ActivityMainBinding
import com.groke.materialapp.databinding.PodmainFragmentBinding

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(binding.container.id, PODMainFragment.newInstance())
                .commit()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
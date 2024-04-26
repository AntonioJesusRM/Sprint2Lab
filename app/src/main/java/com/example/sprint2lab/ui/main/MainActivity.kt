package com.example.sprint2lab.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.sprint2lab.R
import com.example.sprint2lab.databinding.ActivityMainBinding
import com.example.sprint2lab.ui.shape.ShapeActivity


class MainActivity : AppCompatActivity(), View.OnClickListener {
    private val mainViewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        configClickListener()
    }

    private fun configClickListener() {
        binding.ivCircle.setOnClickListener(this)
        binding.ivRectangle.setOnClickListener(this)
        binding.ivTriangle.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.ivCircle -> {
                mainViewModel.setCircle()
            }

            R.id.ivRectangle -> {
                mainViewModel.setRectangle()
            }

            R.id.ivTriangle -> {
                mainViewModel.setTriangle()
            }
        }
        navigateToNextScreen()
    }

    private fun navigateToNextScreen() {
        val intent = Intent(this, ShapeActivity::class.java)
        startActivity(intent)
    }
}
package com.example.sprint2lab.ui.shape

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.example.sprint2lab.R
import com.example.sprint2lab.databinding.ActivityShapeBinding
import com.example.sprint2lab.ui.shape.circle.CircleFragment
import com.example.sprint2lab.ui.shape.triangle.TriangleFragment

class ShapeActivity : AppCompatActivity() {

    private val shapeViewModel: ShapeViewModel by viewModels()
    private lateinit var binding: ActivityShapeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityShapeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setView()
        binding.btnCalc.setOnClickListener { onCalculateAreaButtonClicked() }
    }

    private fun onCalculateAreaButtonClicked() {
        binding.tvArea.text = shapeViewModel.returnArea(supportFragmentManager)
    }

    private fun setView() {
        val shape: String = shapeViewModel.returnShape()
        when (shape) {
            "triangle" -> {
                supportFragmentManager.commit {
                    setReorderingAllowed(true)
                    add<TriangleFragment>(R.id.fragmentShape)
                }
            }

            "circle" -> {
                supportFragmentManager.commit {
                    setReorderingAllowed(true)
                    add<CircleFragment>(R.id.fragmentShape)
                }
            }
        }
    }
}
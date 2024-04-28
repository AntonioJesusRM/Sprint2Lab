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
        val shape = setView()
        binding.btnCalc.setOnClickListener { onCalculateAreaButtonClicked(shape) }
    }

    private fun onCalculateAreaButtonClicked(shape: String) {
        when (shape) {
            "triangle" -> {
                val triangleFragment =
                    supportFragmentManager.findFragmentById(R.id.fragmentShape) as TriangleFragment
                val base =
                    triangleFragment.binding.etBase.text.toString().toDoubleOrNull() ?: return
                val height =
                    triangleFragment.binding.etHeight.text.toString().toDoubleOrNull() ?: return
                binding.tvArea.text = shapeViewModel.returnArea(base, height)
            }
        }
    }

    private fun setView(): String {
        val shape: String = shapeViewModel.returnShape()
        when (shape) {
            "triangle" -> {
                supportFragmentManager.commit {
                    setReorderingAllowed(true)
                    add<TriangleFragment>(R.id.fragmentShape)
                }
            }
        }
        return shape
    }
}
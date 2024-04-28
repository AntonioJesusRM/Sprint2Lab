package com.example.sprint2lab.ui.shape.triangle

import androidx.lifecycle.ViewModel
import com.example.sprint2lab.ui.shape.Triangle

class TriangleViewModel : ViewModel() {
    fun returnTriangleForm(): String {
        val triangle = Triangle(0.0, 0.0)
        return triangle.printCalcArea()
    }
}
package com.example.sprint2lab.ui.shape.rectangle

import androidx.lifecycle.ViewModel
import com.example.sprint2lab.ui.shape.Triangle

class RectangleViewModel : ViewModel() {
    fun returnRectangleForm(): String {
        val triangle = Triangle(0.0, 0.0)
        return triangle.printCalcArea()
    }
}
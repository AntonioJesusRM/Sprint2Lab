package com.example.sprint2lab.ui.shape.rectangle

import androidx.lifecycle.ViewModel
import com.example.sprint2lab.ui.shape.Rectangle

class RectangleViewModel : ViewModel() {
    fun returnRectangleForm(): String {
        val rectangle = Rectangle(0.0, 0.0)
        return rectangle.printCalcArea()
    }
}
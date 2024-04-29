package com.example.sprint2lab.ui.shape.circle

import androidx.lifecycle.ViewModel
import com.example.sprint2lab.ui.shape.Circle

class CircleViewModel : ViewModel() {
    fun returnCircleForm(): String {
        val circle = Circle(0.0)
        return circle.printCalcArea()
    }
}
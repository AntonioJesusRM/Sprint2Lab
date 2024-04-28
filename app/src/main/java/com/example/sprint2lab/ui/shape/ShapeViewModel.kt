package com.example.sprint2lab.ui.shape


import androidx.lifecycle.ViewModel
import com.example.sprint2lab.data.DataShape

class ShapeViewModel : ViewModel() {

    private val shape: String = DataShape.getData()
    fun returnShape(): String {
        return shape
    }

    fun returnArea(base: Double, height: Double): String {
        val area: String
        when (shape) {
            "triangle" -> {
                val triangle = Triangle(base, height)
                area = triangle.calculateArea().toString()
            }

            "circle" -> {
                val circle = Circle(base)
                area = circle.calculateArea().toString()
            }

            "rectangle" -> {
                val rectangle = Rectangle(base, height)
                area = rectangle.calculateArea().toString()
            }

            else -> {
                area = "Error: Shape don't found"
            }
        }
        return area
    }
}
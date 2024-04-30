package com.example.sprint2lab.ui.shape


import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModel
import com.example.sprint2lab.data.DataShape
import com.example.sprint2lab.ui.shape.circle.CircleFragment
import com.example.sprint2lab.ui.shape.rectangle.RectangleFragment
import com.example.sprint2lab.ui.shape.triangle.TriangleFragment

class ShapeViewModel : ViewModel() {

    private val shape: String = DataShape.getData()
    fun returnShape(): String {
        return shape
    }

    fun returnArea(supportFragment: FragmentManager): String {
        return when (shape) {
            "triangle" -> calculateTriangleArea(supportFragment)
            "circle" -> calculateCircleArea(supportFragment)
            "rectangle" -> calculateRectangleArea(supportFragment)
            else -> "Error: Shape don't found"
        }
    }

    private fun calculateTriangleArea(fragment: FragmentManager): String {
        val triangleFragment = fragment as TriangleFragment
        val base = triangleFragment.getBase() ?: 0.0
        val height = triangleFragment.getHeight() ?: 0.0
        val triangle = Triangle(base, height)
        return triangle.calculateArea().toString()
    }

    private fun calculateCircleArea(fragment: FragmentManager): String {
        val circleFragment = fragment as CircleFragment
        val radius = circleFragment.getRadius() ?: 0.0
        val circle = Circle(radius)
        return circle.calculateArea().toString()
    }

    private fun calculateRectangleArea(fragment: FragmentManager): String {
        val rectangleFragment = fragment as RectangleFragment
        val base = rectangleFragment.getBase() ?: 0.0
        val height = rectangleFragment.getHeight() ?: 0.0
        val rectangle = Rectangle(base, height)
        return rectangle.calculateArea().toString()
    }
}
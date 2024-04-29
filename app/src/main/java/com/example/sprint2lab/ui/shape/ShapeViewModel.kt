package com.example.sprint2lab.ui.shape


import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModel
import com.example.sprint2lab.R
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
        val area: String
        when (shape) {
            "triangle" -> {
                val triangleFragment =
                    supportFragment.findFragmentById(R.id.fragmentShape) as TriangleFragment
                val base =
                    triangleFragment.binding.etBase.text.toString().toDoubleOrNull() ?: 0.0
                val height =
                    triangleFragment.binding.etHeight.text.toString().toDoubleOrNull() ?: 0.0
                val triangle = Triangle(base, height)
                area = triangle.calculateArea().toString()
            }

            "circle" -> {
                val circleFragment =
                    supportFragment.findFragmentById(R.id.fragmentShape) as CircleFragment
                val radio =
                    circleFragment.binding.etRadio.text.toString().toDoubleOrNull() ?: 0.0
                val circle = Circle(radio)
                area = circle.calculateArea().toString()
            }

            "rectangle" -> {
                val rectangleFragment =
                    supportFragment.findFragmentById(R.id.fragmentShape) as RectangleFragment
                val base =
                    rectangleFragment.binding.etBase.text.toString().toDoubleOrNull() ?: 0.0
                val height =
                    rectangleFragment.binding.etHeight.text.toString().toDoubleOrNull() ?: 0.0
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
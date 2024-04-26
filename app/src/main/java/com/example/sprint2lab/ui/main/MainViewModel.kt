package com.example.sprint2lab.ui.main

import androidx.lifecycle.ViewModel
import com.example.sprint2lab.data.DataShape

class MainViewModel : ViewModel() {

    fun setCircle() {
        DataShape.setData("circle")
    }

    fun setRectangle() {
        DataShape.setData("rectangle")
    }

    fun setTriangle() {
        DataShape.setData("triangle")
    }
}
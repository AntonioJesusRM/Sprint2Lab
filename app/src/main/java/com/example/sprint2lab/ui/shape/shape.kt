package com.example.sprint2lab.ui.shape

interface Shape {
    fun calculateArea(): Double
}

class Rectangle(private var width: Double, private var height: Double) : Shape {
    override fun calculateArea(): Double {
        return width * height
    }
}

class Circle(private var radius: Double) : Shape {
    override fun calculateArea(): Double {
        return Math.PI * radius * radius
    }
}

class Triangle(private var base: Double, private var height: Double) : Shape {
    override fun calculateArea(): Double {
        return base * height
    }
}
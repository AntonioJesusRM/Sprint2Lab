package com.example.sprint2lab.ui.shape

interface Shape {
    fun calculateArea(): Double
    fun printCalcArea(): String
}

class Rectangle(private var width: Double, private var height: Double) : Shape {
    override fun calculateArea(): Double {
        return width * height
    }

    override fun printCalcArea(): String {
        return "<div style=\"font-size: 24px; text-align: center;\"> A = B * H</div>"
    }

}

class Circle(private var radius: Double) : Shape {
    override fun calculateArea(): Double {
        return Math.PI * radius * radius
    }

    override fun printCalcArea(): String {
        return "<div style=\"font-size: 24px; text-align: center;\"> A = π * r<sup>2</sup></div>"
    }
}

class Triangle(private var base: Double, private var height: Double) : Shape {
    override fun calculateArea(): Double {
        return (base * height) / 2
    }

    override fun printCalcArea(): String {
        return "<div style=\"font-size: 24px; text-align: center;\"> A = <sup> B * H</sup>/<sub>2</sub></div>"
    }
}
package com.example.sprint2lab.data

object DataShape {
    private lateinit var type: String

    fun setData(data: String) {
        this.type = data
    }

    fun getData(): String {
        return type
    }
}
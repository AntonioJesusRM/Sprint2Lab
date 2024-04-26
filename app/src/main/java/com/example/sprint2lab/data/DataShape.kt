package com.example.sprint2lab.data

object DataShape {
    private var type: String? = null

    fun setData(data: String) {
        this.type = data
    }

    fun getData(): String? {
        return type
    }
}
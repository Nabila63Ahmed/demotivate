package com.example.demotivate

object Util {
    /**
     * returns a random integer between 0(inclusive) and rangeBound(exclusive)
     * */
    fun generateRandomNumber(rangeBound: Int): Int {
        if (rangeBound <= 0)
            throw Exception("Empty range")

        return (0 until rangeBound).random()
    }
}
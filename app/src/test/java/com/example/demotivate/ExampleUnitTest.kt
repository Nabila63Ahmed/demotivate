package com.example.demotivate

import com.example.demotivate.viewmodel.randomIndex
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun random_inRange() {
        val randNumber = randomIndex(6)
        assertTrue("The value of randNumber was not between 1 and 6", randNumber in 0 until 6)
    }
}
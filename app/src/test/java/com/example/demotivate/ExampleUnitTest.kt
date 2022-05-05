package com.example.demotivate

import com.example.demotivate.viewmodel.randomIndex
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun randomNumber_inRange() {
        val randomNumber = randomIndex(6)
        assertTrue("The value of randomNumber was not between 1 and 6", randomNumber in 0 until 6)
    }
}
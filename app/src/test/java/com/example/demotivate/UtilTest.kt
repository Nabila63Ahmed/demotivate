package com.example.demotivate

import com.google.common.truth.Truth.assertThat
import org.junit.Assert.assertThrows
import org.junit.Test

class UtilTest {

    @Test
    fun `asserts that the random result is in range`() {
        val result = Util.generateRandomNumber(6)
        assertThat(result).isAtMost(5)
        assertThat(result).isAtLeast(0)
    }

    @Test
    fun `empty range exception thrown for invalid bound`() {
        val exception = assertThrows(Exception::class.java) {
            Util.generateRandomNumber(0)
        }

        assertThat(exception.message).isEqualTo("Empty range")
    }
}
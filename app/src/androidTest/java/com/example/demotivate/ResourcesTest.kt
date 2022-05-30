package com.example.demotivate

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.google.common.truth.Truth.assertThat
import org.junit.Test

class ResourcesTest {
    @Test
    fun correctAppName() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        assertThat(context.getString(R.string.app_name)).isEqualTo("Demotivate")
    }
}
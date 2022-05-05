package com.example.demotivate.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.core.view.isVisible
import com.example.demotivate.R
import com.example.demotivate.viewmodel.QuotesViewModel

class MainActivity : AppCompatActivity() {

    private val model: QuotesViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val demotivateButton: Button = findViewById(R.id.button)
        demotivateButton.setOnClickListener {
            val initialTextView: TextView = findViewById(R.id.initialTextView)
            val quoteTextView: TextView = findViewById(R.id.quoteTextView)
            val authorTextView: TextView = findViewById(R.id.authorTextView)

            if (initialTextView.isVisible) {
                initialTextView.visibility = View.INVISIBLE
                quoteTextView.visibility = View.VISIBLE
                authorTextView.visibility = View.VISIBLE
            }
        }

    }
}
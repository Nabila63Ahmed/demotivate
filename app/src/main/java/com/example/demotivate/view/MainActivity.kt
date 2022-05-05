package com.example.demotivate.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import com.example.demotivate.QuotesQuery
import com.example.demotivate.R
import com.example.demotivate.apolloClient
import com.example.demotivate.viewmodel.QuotesViewModel
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val model: QuotesViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.lifecycleScope.launchWhenResumed {
            val response = apolloClient.query(QuotesQuery()).execute()
            Log.d("QuotesList", "Success ${response.data}")
        }

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
            model.updateAndGetQuoteData().observe(this) { currentQuote ->
                "\"${currentQuote.quote}\"".also { quoteTextView.text = it }
                "- ${currentQuote.author}".also { authorTextView.text = it }
            }
        }

    }
}
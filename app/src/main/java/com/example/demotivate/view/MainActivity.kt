package com.example.demotivate.view

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import com.apollographql.apollo3.exception.ApolloException
import com.example.demotivate.QuotesQuery
import com.example.demotivate.R
import com.example.demotivate.graphql.apolloClient
import com.example.demotivate.viewmodel.QuotesViewModel

class MainActivity : AppCompatActivity() {
    private val model: QuotesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val demotivateButton: Button = findViewById(R.id.button)

        demotivateButton.isEnabled = false
        getQuotesQuery()

        demotivateButton.setOnClickListener {
            val initialTextView: TextView = findViewById(R.id.initialTextView)
            val quoteTextView: TextView = findViewById(R.id.quoteTextView)
            val authorTextView: TextView = findViewById(R.id.authorTextView)

            // In case of having the initial display, a change in displayed elements is required
            if (initialTextView.isVisible) {
                initialTextView.visibility = View.INVISIBLE
                quoteTextView.visibility = View.VISIBLE
                authorTextView.visibility = View.VISIBLE
            }

            val currentQuote: QuotesQuery.Quote? = model.updateAndGetQuoteData().value

            if (currentQuote != null) {
                "\" ${currentQuote.quote}\"".also { quoteTextView.text = it }
                "- ${currentQuote.author}".also { authorTextView.text = it }
            }
        }

    }

    /**
     * Uses the Apollo client to fetch all quotes, posts them to the ViewModel
     * and enables the click button.
     */
    private fun getQuotesQuery() {
        val demotivateButton: Button = findViewById(R.id.button)

        this.lifecycleScope.launchWhenResumed {
            try {
                val response = apolloClient.query(QuotesQuery()).execute()
                response.data?.let { model.setQuotes(it.quotes) }

                demotivateButton.isEnabled = true
            } catch (exception: ApolloException) {
                Log.d("QuotesList", "Unable to fetch quotes", exception)
            }
        }
    }
}

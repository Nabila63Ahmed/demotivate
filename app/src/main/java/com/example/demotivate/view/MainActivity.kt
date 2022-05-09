package com.example.demotivate.view

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import com.apollographql.apollo3.exception.ApolloException
import com.example.demotivate.QuotesQuery
import com.example.demotivate.databinding.ActivityMainBinding
import com.example.demotivate.graphql.apolloClient
import com.example.demotivate.viewmodel.QuotesViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val model: QuotesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.isEnabled = false
        getQuotesQuery()

        binding.button.setOnClickListener {
            // In case of having the initial display, a change in displayed elements is required
            if (binding.initialTextView.isVisible) {
                binding.initialTextView.visibility = View.INVISIBLE
                binding.quoteTextView.visibility = View.VISIBLE
                binding.authorTextView.visibility = View.VISIBLE
            }

            model.updateAndGetQuoteData().observe(this) { currentQuote ->
                "\" ${currentQuote.quote}\"".also { binding.quoteTextView.text = it }
                "- ${currentQuote.author}".also { binding.authorTextView.text = it }
            }
        }
    }

    /**
     * Uses the Apollo client to fetch all quotes, posts them to the ViewModel
     * and enables the click button.
     */
    private fun getQuotesQuery() {
        this.lifecycleScope.launchWhenResumed {
            try {
                val response = apolloClient.query(QuotesQuery()).execute()
                response.data?.let { model.setQuotes(it.quotes) }

                binding.button.isEnabled = true
            } catch (exception: ApolloException) {
                Log.d("QuotesList", "Unable to fetch quotes", exception)
            }
        }
    }
}

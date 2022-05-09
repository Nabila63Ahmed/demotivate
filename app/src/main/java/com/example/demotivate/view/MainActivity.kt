package com.example.demotivate.view

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.demotivate.databinding.ActivityMainBinding
import com.example.demotivate.viewmodel.QuotesViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val model: QuotesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.isEnabled = false
        model.getQuotesFromAPI()
        binding.button.isEnabled = true

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
}

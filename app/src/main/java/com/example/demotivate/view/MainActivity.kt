package com.example.demotivate.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.demotivate.R
import com.example.demotivate.data.db.QuotesDatabase
import com.example.demotivate.data.repositories.QuotesRepository
import com.example.demotivate.databinding.ActivityMainBinding
import com.example.demotivate.viewmodel.QuotesViewModel
import com.example.demotivate.viewmodel.QuotesViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db = QuotesDatabase(this)
        val repository = QuotesRepository(db)
        val factory = QuotesViewModelFactory(repository)

        val model: QuotesViewModel by viewModels { factory }
        val initialFragment = InitialFragment()
        val quoteFragment = QuoteFragment()

        var isFirstClick = true

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, initialFragment)
            commit()
        }

        binding.button.isEnabled = false
        model.getQuotesFromAPI()
        binding.button.isEnabled = true

        binding.button.setOnClickListener {
            model.updateAndGetQuoteData().observe(this) { currentQuote ->
                if (isFirstClick) {
                    isFirstClick = false
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.flFragment, quoteFragment)
                        commit()
                    }
                } else {
                    "\"${
                        currentQuote.quote
                            .replace("\"", "")
                            .replace("\u201C", "")
                            .replace("\u201D", "")
                    }\""
                        .also { quoteFragment.binding.quoteTextView.text = it }
                    "- ${currentQuote.author}".also { quoteFragment.binding.authorTextView.text = it }
                }
            }
        }
    }
}

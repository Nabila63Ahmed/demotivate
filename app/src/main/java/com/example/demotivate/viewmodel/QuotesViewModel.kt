package com.example.demotivate.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.demotivate.model.Quote
import com.example.demotivate.model.QuotesProvider

class QuotesViewModel: ViewModel() {

    private val quoteData = MutableLiveData<Quote>()
    private val quotes = QuotesProvider().getQuotes()

    fun updateAndGetQuoteData (): LiveData<Quote> {
        val currentIndex = randomIndex(quotes.size)

        quoteData.value = quotes[currentIndex]

        return quoteData
    }

    private fun randomIndex (size: Int) = (0 until size).random()
}
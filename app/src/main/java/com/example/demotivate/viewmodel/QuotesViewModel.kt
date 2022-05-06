package com.example.demotivate.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.demotivate.QuotesQuery

class QuotesViewModel : ViewModel() {
    private lateinit var quotes: List<QuotesQuery.Quote>
    private val quoteData = MutableLiveData<QuotesQuery.Quote>()

    fun setQuotes(quotes: List<QuotesQuery.Quote>) {
        this.quotes = quotes
    }

    /*
     * Picks a quote at random and updates the MutableLiveData.
     */
    fun updateAndGetQuoteData(): LiveData<QuotesQuery.Quote> {
        val currentIndex = randomIndex(quotes.size)
        quoteData.value = quotes[currentIndex]

        return quoteData
    }
}

/*
* Given an array size, it returns a random number within the indices of the array.
*/
fun randomIndex(size: Int) = (0 until size).random()

package com.example.demotivate.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.demotivate.QuotesQuery
import com.example.demotivate.graphql.QuotesProvider
import kotlinx.coroutines.launch

class QuotesViewModel : ViewModel() {
    private lateinit var quotes: List<QuotesQuery.Quote>
    private val quoteData = MutableLiveData<QuotesQuery.Quote>()

    /**
     * Sets the ViewModel quotes to the fetched quotes by the Provider.
     */
    fun getQuotesFromAPI() {
        viewModelScope.launch {
            quotes = QuotesProvider().getQuotesFromApollo()!!
        }
    }

    /**
     * Picks a quote at random and updates the MutableLiveData.
     */
    fun updateAndGetQuoteData(): LiveData<QuotesQuery.Quote> {
        quoteData.value = quotes.random()

        return quoteData
    }
}

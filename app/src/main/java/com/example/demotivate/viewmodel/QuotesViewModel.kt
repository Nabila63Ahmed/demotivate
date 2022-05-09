package com.example.demotivate.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apollographql.apollo3.exception.ApolloException
import com.example.demotivate.QuotesQuery
import com.example.demotivate.graphql.apolloClient
import kotlinx.coroutines.launch

class QuotesViewModel : ViewModel() {
    private lateinit var quotes: List<QuotesQuery.Quote>
    private val quoteData = MutableLiveData<QuotesQuery.Quote>()

    /**
     * Uses the Apollo client to fetch all quotes and sets them to the ViewModel quotes.
     */
    fun getQuotesFromAPI() {
        viewModelScope.launch {
            try {
                val response = apolloClient.query(QuotesQuery()).execute()
                response.data?.let { quotes = it.quotes }
            } catch (exception: ApolloException) {
                Log.d("QuotesList", "Unable to fetch quotes", exception)
            }
        }
    }

    /**
     * Picks a quote at random and updates the MutableLiveData.
     */
    fun updateAndGetQuoteData(): LiveData<QuotesQuery.Quote> {
        val currentIndex = randomIndex(quotes.size)
        quoteData.value = quotes[currentIndex]

        return quoteData
    }
}

/**
 * Given an array size, it returns a random number within the indices of the array.
 */
fun randomIndex(size: Int) = (0 until size).random()

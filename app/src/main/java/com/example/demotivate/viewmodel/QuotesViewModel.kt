package com.example.demotivate.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.demotivate.QuotesQuery
import com.example.demotivate.Util
import com.example.demotivate.data.db.entities.Quote
import com.example.demotivate.data.repositories.QuotesRepository
import com.example.demotivate.graphql.QuotesProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class QuotesViewModel(
    private val repository: QuotesRepository
) : ViewModel() {
    private lateinit var quotes: List<QuotesQuery.Quote>
    private val quoteData = MutableLiveData<QuotesQuery.Quote>()

    fun insert(item: Quote) = CoroutineScope(Dispatchers.Main).launch {
        repository.insert(item)
    }

    fun insertAll(items: List<Quote>) = CoroutineScope(Dispatchers.Main).launch {
        repository.insertAll(items)
    }

    fun delete(item: Quote) = CoroutineScope(Dispatchers.Main).launch {
        repository.delete(item)
    }

    fun getAllQuotes() = repository.getAllQuotes()
    
    fun getQuoteByID(id: Int) = repository.getQuoteByID(id)

    /**
     * Sets the ViewModel quotes to the fetched quotes by the Provider.
     */
    fun getQuotesFromAPI() {
        viewModelScope.launch {
            quotes = QuotesProvider().getQuotesFromApollo()!!
        }
    }

    fun getFirstQuote() = quotes.random()

    /**
     * Picks a quote at random and updates the MutableLiveData.
     */
    fun updateAndGetQuoteData(): LiveData<QuotesQuery.Quote> {
        quoteData.value = quotes[Util.generateRandomNumber(quotes.size)]

        return quoteData
    }
}

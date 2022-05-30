package com.example.demotivate.data.repositories

import com.example.demotivate.data.db.QuotesDatabase
import com.example.demotivate.data.db.entities.Quote

class QuotesRepository(
    private val db: QuotesDatabase
) {

    suspend fun insert(quote: Quote) = db.getQuotesDao().insert(quote)
    suspend fun insertAll(quotes: List<Quote>) = db.getQuotesDao().insertAll(quotes)

    suspend fun delete(quote: Quote) = db.getQuotesDao().delete(quote)

    fun getAllQuotes(): List<Quote> = db.getQuotesDao().getAllQuotes()
    fun getQuoteByID(id: Int): Quote = db.getQuotesDao().getQuoteByID(id)
}
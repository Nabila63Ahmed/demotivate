package com.example.demotivate.graphql

import android.util.Log
import com.apollographql.apollo3.exception.ApolloException
import com.example.demotivate.QuotesQuery
import com.example.demotivate.QuotesQuery.Quote

class QuotesProvider {

    /**
     * Uses the Apollo client to fetch all quotes.
     */
    suspend fun getQuotesFromApollo(): List<Quote>? {
        try {
            val response = apolloClient.query(QuotesQuery()).execute()
            response.data?.let { return it.quotes }
        } catch (exception: ApolloException) {
            Log.d("QuotesList", "Unable to fetch quotes", exception)
        }

        return null
    }
}

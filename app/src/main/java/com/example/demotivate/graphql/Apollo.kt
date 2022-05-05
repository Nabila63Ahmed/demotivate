package com.example.demotivate.graphql

import com.apollographql.apollo3.ApolloClient

val apolloClient = ApolloClient.Builder()
    .serverUrl("https://demotivation-quotes-api.herokuapp.com/graphql")
    .build()

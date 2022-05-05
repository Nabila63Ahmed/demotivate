package com.example.demotivate.model

class QuotesProvider {
    private val quotes = arrayListOf<Quote>()

    init {
        quotes.add(Quote(1, "Trying is the first step toward failure.","Homer Simpson"))
        quotes.add(Quote(2, "Not everything is a lesson. Sometimes you just fail.","Dwight Schrute"))
        quotes.add(Quote(3, "Always remember that you are absolutely unique. Just like everyone else.","Margaret Mead"))
        quotes.add(Quote(4, "If at first you don't succeed, try, try again. Then quit. No use being a damn fool about it.","W. C. Fields"))
        quotes.add(Quote(5, "It could be that your purpose in life is to serve as a warning to others.","Ashleigh Brilliant"))
        quotes.add(Quote(6, "Those who doubt your ability probably have a valid reason.","unknown"))
    }

    fun getQuotes() = quotes
}
package com.example.demotivate.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.demotivate.data.db.entities.Quote

@Dao
interface QuotesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(quote: Quote)

    @Insert
    suspend fun insertAll(quotes: List<Quote>)

    @Delete
    suspend fun delete(quote: Quote)

    @Query("SELECT * FROM quotes_table")
    fun getAllQuotes(): List<Quote>

    @Query("SELECT * FROM quotes_table WHERE id = :id")
    fun getQuoteByID(id: Int): Quote
}

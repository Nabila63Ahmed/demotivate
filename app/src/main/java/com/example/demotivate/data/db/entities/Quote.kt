package com.example.demotivate.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "quotes_table")
data class Quote(
    @ColumnInfo(name = "quote_text")
    val quote: String,
    @ColumnInfo(name = "author_text")
    val author: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}
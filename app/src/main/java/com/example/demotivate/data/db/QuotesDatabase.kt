package com.example.demotivate.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.demotivate.data.db.entities.Quote


@Database(
    entities = [Quote::class],
    version = 1
)
abstract class QuotesDatabase : RoomDatabase() {

    abstract fun getQuotesDao(): QuotesDao

    companion object {
        @Volatile
        private var instance: QuotesDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also { instance = it }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                QuotesDatabase::class.java, "QuotesDB.db"
            )
                .build()
    }
}
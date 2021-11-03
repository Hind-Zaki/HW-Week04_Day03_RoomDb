package com.shady.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database (entities = arrayOf(Word:: class),version = 1, exportSchema = false)

public abstract class WordRoomDatabase:RoomDatabase() {

    abstract fun wordDao():WordDao

    @Volatile
    private var INSTANCE:WordRoomDatabase? =null

    fun getDataBase(context: Context):WordRoomDatabase{
        return INSTANCE?:synchronized(this){
            val instance = Room.databaseBuilder(
                context.applicationContext,WordRoomDatabase::class.java
          ,"word_database"  ).build()
            INSTANCE= instance

            return instance
        }
    }


    }




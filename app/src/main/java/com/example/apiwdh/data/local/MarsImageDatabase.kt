package com.example.apiwdh.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.apiwdh.data.model.MarsPhoto
import com.example.apiwdh.data.model.RoverCamera
import com.example.apiwdh.data.utils.RoverTypeConverter

@Database(entities = [MarsPhoto::class], version = 1)
@TypeConverters(RoverTypeConverter::class)
abstract class MarsImageDatabase : RoomDatabase() {
    abstract val dao: MarsImageDatabaseDao
}

private lateinit var INSTANCE: MarsImageDatabase

fun getDatabase(context: Context): MarsImageDatabase {

    synchronized(MarsImageDatabase::class.java) {
        if (!::INSTANCE.isInitialized) {

            INSTANCE = Room.databaseBuilder(
                context.applicationContext,
                MarsImageDatabase::class.java,
                "MarsImage_database"
            ).build()
        }
        return INSTANCE
    }

}


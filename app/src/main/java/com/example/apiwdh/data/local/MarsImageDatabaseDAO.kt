package com.example.apiwdh.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.apiwdh.data.model.MarsPhoto

@Dao
interface MarsImageDatabaseDao {

    @Query("SELECT * FROM MarsPhoto ")
    fun getMarsImages() : LiveData<List<MarsPhoto>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMarsImages(pictures: List<MarsPhoto>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMarsImage(picture: MarsPhoto)

    @Delete
    suspend fun deleteMarsImage(picture: MarsPhoto)

}


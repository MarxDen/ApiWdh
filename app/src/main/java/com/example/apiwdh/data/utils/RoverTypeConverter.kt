package com.example.apiwdh.data.utils

import androidx.room.TypeConverter
import com.example.apiwdh.data.model.RoverCamera

class RoverTypeConverter {
    @TypeConverter
    fun convertRoverCameraToString(camera: RoverCamera): String {
        val shortName = camera.name
        val fullName = camera.fullName
        return "$shortName,$fullName"
    }
    @TypeConverter
    fun convertStringToRoverCamera(stringDB: String): RoverCamera {
        val split = stringDB.split(",")
        return RoverCamera(split[0], split[1])
    }
}
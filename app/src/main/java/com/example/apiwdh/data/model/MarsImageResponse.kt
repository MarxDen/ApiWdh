package com.example.apiwdh.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

data class MarsImageResponse(
    val photos: List<MarsPhoto>

)
@Entity
data class MarsPhoto(
    @PrimaryKey
    val id: Int,
    val camera: RoverCamera,
    @Json(name= "img_src")
    val marsPicture: String
) {
    fun getFormatedMarsPicture(): String {
        val tempLink = marsPicture.replace(".jpl", "")
        return tempLink.replace("http", "https")
    }
}

data class RoverCamera(
    val name: String,
    @Json(name="full_name")
    val fullName: String
)



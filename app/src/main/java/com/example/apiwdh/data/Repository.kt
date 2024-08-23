package com.example.apiwdh.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.apiwdh.data.local.MarsImageDatabase

import com.example.apiwdh.data.model.MarsPhoto
import com.example.apiwdh.data.remote.MarsImageApi

class Repository(private val api: MarsImageApi, private val db: MarsImageDatabase) {


    //private val _marsImages = MutableLiveData<List<MarsPhoto>>()
    val marsImages = db.dao.getMarsImages()



    suspend fun loadMarsImages() {
        try {

            val result = api.retrofitService.getMarsImage()

            db.dao.insertMarsImages(result.photos)




        }catch (e:Exception){
            Log.d("Repository", "API: $e")
        }
    }



}
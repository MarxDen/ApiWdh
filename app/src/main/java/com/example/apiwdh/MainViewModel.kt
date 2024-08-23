package com.example.apiwdh

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.apiwdh.data.Repository
import com.example.apiwdh.data.local.getDatabase

import com.example.apiwdh.data.remote.MarsImageApi
import kotlinx.coroutines.launch

class MainViewModel(application: Application): AndroidViewModel(application){
    private val repository = Repository(MarsImageApi, getDatabase(application))

    val marsImages = repository.marsImages

    fun loadMarsImages() {
        viewModelScope.launch {
            repository.loadMarsImages()

        }
    }

}
package com.example.apiwdh.data.remote

import com.example.apiwdh.data.model.MarsImageResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

val apiKey = ""

const val BASE_URL = "https://api.nasa.gov/mars-photos/api/v1/"


private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface MarsImageApiService {
    @GET("rovers/curiosity/photos?sol=1000&api_key=DEMO_KEY")
    suspend fun getMarsImage( ): MarsImageResponse
}

object MarsImageApi {
    val retrofitService: MarsImageApiService by lazy { retrofit.create(MarsImageApiService::class.java) }
}
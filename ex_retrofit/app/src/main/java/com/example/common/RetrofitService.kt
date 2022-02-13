package com.example.common

import retrofit2.Call
import retrofit2.http.*

interface RetrofitService {


    @GET("safeDriving/forecast")
    fun getForecast(
        @Query("key") key: String,
        @Query("type") type: String
    ): Call<ForeCastResponse>

}
package com.alessandrofarandagancio.openweather.api.openweather

import com.alessandrofarandagancio.openweather.api.openweather.model.WeatherData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("weather")
    suspend fun getCurrent(
        @Query("lat") lat: String,
        @Query("lon") lon: String,
        @Query("appid") appid: String = "2a5286593d1912c078ff828b5357f7d6"
    ): Response<WeatherData>


}
package com.alessandrofarandagancio.openweather.api.openweather

import com.alessandrofarandagancio.openweather.api.openweather.model.WeatherData
import retrofit2.Response

interface ApiHelper {

    suspend fun getCurrent(lat: String, lon: String): Response<WeatherData>
}
package com.alessandrofarandagancio.openweather.api.openweather

import com.alessandrofarandagancio.openweather.api.openweather.model.WeatherData
import retrofit2.Response
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(private val apiService: ApiService) : ApiHelper {

    override suspend fun getCurrent(
        lat: String,
        lon: String
    ): Response<WeatherData> {
        return apiService.getCurrent(lat = lat, lon = lon)
    }

}
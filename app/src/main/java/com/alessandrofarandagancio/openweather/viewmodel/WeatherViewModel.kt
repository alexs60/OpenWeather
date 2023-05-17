package com.alessandrofarandagancio.openweather.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.alessandrofarandagancio.openweather.api.openweather.model.Weather

class WeatherViewModel : ViewModel() {
    private val _searchText = mutableStateOf(String())
    val searchText: String get() = _searchText.value

    fun setSearchText(text: String) {
        _searchText.value = text
    }

    private val _weather = mutableStateOf(Weather.empty())
    val weather: Weather get() = _weather.value

    fun setWeather(weather: Weather) {
        _weather.value = weather
    }

    private val _location = mutableStateOf(String())
    val location: String get() = _location.value

    fun setLocation(location: String) {
        _location.value = location
    }



}

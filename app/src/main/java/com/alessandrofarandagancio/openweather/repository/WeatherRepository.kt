//package com.alessandrofarandagancio.openweather.repository
//
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.MutableLiveData
//import com.alessandrofarandagancio.openweather.api.openweather.ApiHelper
//import com.alessandrofarandagancio.openweather.api.openweather.model.WeatherData
//import javax.inject.Inject
//
//
//class WeatherRepository @Inject constructor(
//    private val apiHelper: ApiHelper
//) {
//
//    private var _charactersList = MutableLiveData<List<Character>>()
//    val charactersList: LiveData<List<Character>> get() = _charactersList
//
//    fun getAllCharacters() = charactersList
//
//    suspend fun refreshCharacter() {
//        var weatherData = apiHelper.getCurrent("", "")
//        if (weatherData.isSuccessful) {
//            val responseBody = weatherData.body() as WeatherData
//            responseBody.let {
//                _charactersList.value = responseBody
//            }
//        }
//    }
//}
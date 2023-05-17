package com.alessandrofarandagancio.openweather.api.openweather.model

import com.squareup.moshi.Json

data class WeatherData(
  @field:Json(name = "coord")
  val coord: Coord,

  @field:Json(name = "weather")
  val weather: List<Weather>,

  @field:Json(name = "base")
  val base: String,

  @field:Json(name = "main")
  val main: Main,

  @field:Json(name = "visibility")
  val visibility: Int,

  @field:Json(name = "wind")
  val wind: Wind,

  @field:Json(name = "rain")
  val rain: Rain?,

  @field:Json(name = "clouds")
  val clouds: Clouds,

  @field:Json(name = "dt")
  val dt: Long,

  @field:Json(name = "sys")
  val sys: Sys,

  @field:Json(name = "timezone")
  val timezone: Int,

  @field:Json(name = "id")
  val id: Int,

  @field:Json(name = "name")
  val name: String,

  @field:Json(name = "cod")
  val cod: Int
)

data class Coord(
  @field:Json(name = "lon")
  val lon: Double,

  @field:Json(name = "lat")
  val lat: Double
)

data class Weather(
  @field:Json(name = "id")
  val id: String,

  @field:Json(name = "main")
  val main: String,

  @field:Json(name = "description")
  val description: String,

  @field:Json(name = "icon")
  val icon: String
){
  companion object {
    fun empty(): Weather {
      return Weather("701", "Mist", "mist", "50n")
    }
  }
}

data class Main(
  @field:Json(name = "temp")
  val temp: Double,

  @field:Json(name = "feels_like")
  val feelsLike: Double,

  @field:Json(name = "temp_min")
  val tempMin: Double,

  @field:Json(name = "temp_max")
  val tempMax: Double,

  @field:Json(name = "pressure")
  val pressure: Int,

  @field:Json(name = "humidity")
  val humidity: Int,

  @field:Json(name = "sea_level")
  val seaLevel: Int,

  @field:Json(name = "grnd_level")
  val groundLevel: Int
)

data class Wind(
  @field:Json(name = "speed")
  val speed: Double,

  @field:Json(name = "deg")
  val deg: Int,

  @field:Json(name = "gust")
  val gust: Double
)

data class Rain(
  @field:Json(name = "1h")
  val oneHour: Double
)

data class Clouds(
  @field:Json(name = "all")
  val all: Int
)

data class Sys(
  @field:Json(name = "type")
  val type: Int,

  @field:Json(name = "id")
  val id: Int,

  @field:Json(name = "country")
  val country: String,

  @field:Json(name = "sunrise")
  val sunrise: Long,

  @field:Json(name = "sunset")
  val sunset: Long
)

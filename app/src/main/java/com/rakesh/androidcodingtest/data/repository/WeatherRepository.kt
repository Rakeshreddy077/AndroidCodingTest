package com.rakesh.androidcodingtest.data.repository

import com.rakesh.androidcodingtest.data.api.WeatherApiService
import com.rakesh.androidcodingtest.data.model.WeatherResponse
import com.rakesh.androidcodingtest.utils.NetworkResult
import javax.inject.Inject


//a repository class that handles data operations and acts as a single source of truth:
class WeatherRepository @Inject constructor(private val weatherApiService: WeatherApiService) {

    suspend fun getWeather(cityName: String): NetworkResult<WeatherResponse> {

        val response = weatherApiService.getWeather(cityName)

        return if (response.isSuccessful) {
            val responseBody = response.body()
            if (responseBody != null) {
                NetworkResult.Success(data = responseBody)
            } else {
                NetworkResult.Error(message = response.message())
            }
        } else {
            NetworkResult.Error(message = response.code().toString())
        }
    }

    suspend fun getWeatherByLocation(
        latitude: Double,
        longitude: Double
    ): NetworkResult<WeatherResponse> {
        val response = weatherApiService.getCurrentLocationWeather(latitude, longitude)
        return if (response.isSuccessful) {
            val responseBody = response.body()
            if (responseBody != null) {
                NetworkResult.Success(data = responseBody)
            } else {
                NetworkResult.Error(message = response.message())
            }
        } else {
            NetworkResult.Error(message = response.code().toString())
        }
    }

}
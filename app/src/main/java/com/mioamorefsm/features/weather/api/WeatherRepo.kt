package com.mioamorefsm.features.weather.api

import com.mioamorefsm.base.BaseResponse
import com.mioamorefsm.features.task.api.TaskApi
import com.mioamorefsm.features.task.model.AddTaskInputModel
import com.mioamorefsm.features.weather.model.ForeCastAPIResponse
import com.mioamorefsm.features.weather.model.WeatherAPIResponse
import io.reactivex.Observable

class WeatherRepo(val apiService: WeatherApi) {
    fun getCurrentWeather(zipCode: String): Observable<WeatherAPIResponse> {
        return apiService.getTodayWeather(zipCode)
    }

    fun getWeatherForecast(zipCode: String): Observable<ForeCastAPIResponse> {
        return apiService.getForecast(zipCode)
    }
}
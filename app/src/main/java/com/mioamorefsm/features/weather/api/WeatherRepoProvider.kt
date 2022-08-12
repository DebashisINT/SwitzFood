package com.mioamorefsm.features.weather.api

import com.mioamorefsm.features.task.api.TaskApi
import com.mioamorefsm.features.task.api.TaskRepo

object WeatherRepoProvider {
    fun weatherRepoProvider(): WeatherRepo {
        return WeatherRepo(WeatherApi.create())
    }
}
package yousef.beiruty.weather.data.repository

import yousef.beiruty.weather.model.Weather
import yousef.beiruty.weather.utils.Result
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {
    fun getWeatherForecast(city: String): Flow<Result<Weather>>
}
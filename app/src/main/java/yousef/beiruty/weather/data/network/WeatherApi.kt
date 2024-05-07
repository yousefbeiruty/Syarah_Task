package yousef.beiruty.weather.data.network

import yousef.beiruty.weather.BuildConfig
import yousef.beiruty.weather.data.model.ForecastResponse
import yousef.beiruty.weather.utils.DEFAULT_WEATHER_DESTINATION
import yousef.beiruty.weather.utils.NUMBER_OF_DAYS
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("forecast.json")
    suspend fun getWeatherForecast(
        @Query("key") key: String = BuildConfig.API_KEY,
        @Query("q") city: String = DEFAULT_WEATHER_DESTINATION,
        @Query("days") days: Int = NUMBER_OF_DAYS,
    ): ForecastResponse
}
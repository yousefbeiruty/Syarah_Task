package yousef.beiruty.weather.data.repository

import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import yousef.beiruty.weather.data.model.toWeather
import yousef.beiruty.weather.data.network.WeatherApi
import yousef.beiruty.weather.data.sampleForecastResponse
import yousef.beiruty.weather.model.Weather
import yousef.beiruty.weather.utils.Result
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class DefaultWeatherRepositoryTest {
    private lateinit var repository: DefaultWeatherRepository
    private val weatherApi = mockk<WeatherApi>()

    @Before
    fun setup() {
        repository = DefaultWeatherRepository(weatherApi)
    }

    @Test
    fun `when getWeatherForecast is called, it should emit loading state and then success state`() =
        runTest {
            coEvery {
                weatherApi.getWeatherForecast(
                    any(),
                    any(),
                    any()
                )
            } returns sampleForecastResponse

            val results = mutableListOf<Result<Weather>>()
            repository.getWeatherForecast("Munich").collect { result ->
                results.add(result)
            }
            assertEquals(Result.Loading, results[0])

            assertEquals(Result.Success(sampleForecastResponse.toWeather()), results[1])
        }
}
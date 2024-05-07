package yousef.beiruty.weather.ui

import app.cash.turbine.test
import junit.framework.TestCase.assertEquals
import yousef.beiruty.weather.data.repository.FakeWeatherRepository
import yousef.beiruty.weather.data.repository.WeatherRepository
import yousef.beiruty.weather.data.repository.fakeWeather
import yousef.beiruty.weather.ui.weather.WeatherUiState
import yousef.beiruty.weather.ui.weather.WeatherViewModel
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class WeatherViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private lateinit var viewModel: WeatherViewModel

    private val weatherRepository: WeatherRepository = FakeWeatherRepository

    @Before
    fun setUp() {
        viewModel = WeatherViewModel(weatherRepository)
    }

    @Test
    fun `when getWeather completes, it should emit success state`() = runTest {
        viewModel.uiState.test {

            assertEquals(WeatherUiState(weather = fakeWeather), awaitItem())
        }
    }

    @Test
    fun `when getWeather completes, it should emit success state with humidity of 60`() = runTest {
        viewModel.uiState.test {

            assertEquals(WeatherUiState(weather = fakeWeather), awaitItem())
            assertEquals(WeatherUiState(weather = fakeWeather).weather?.humidity, 60)
        }
    }
}
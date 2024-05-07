package yousef.beiruty.weather.ui.weather

import yousef.beiruty.weather.model.Weather

data class WeatherUiState(
    val weather: Weather? = null,
    val isLoading: Boolean = false,
    val errorMessage: String = "",
)

package yousef.beiruty.weather

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dagger.hilt.android.AndroidEntryPoint
import yousef.beiruty.weather.ui.theme.WeatherTheme
import yousef.beiruty.weather.ui.weather.WeatherScreen

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherTheme {
                WeatherScreen()
            }
        }
    }
}

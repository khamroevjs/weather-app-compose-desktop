import androidx.compose.material.MaterialTheme
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application


val API_KEY: String = System.getenv("WEATHER_API_TOKEN")

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Weather App",
        state = WindowState(width = 800.dp, height = 700.dp)
    ) {
        val repository = Repository(API_KEY)
        MaterialTheme {
            WeatherScreen(repository)
        }
    }
}

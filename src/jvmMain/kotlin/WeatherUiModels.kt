data class WeatherCard(
    val condition: String,
    val iconUrl: String,
    val temperature: Double,
    val feelsLike: Double,
    val chanceOfRain: Double? = null,
)

data class WeatherResults(
    val currentWeather: WeatherCard,
    val forecast: List<WeatherCard>,
)

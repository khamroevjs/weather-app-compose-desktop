import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WeatherResponse(
    val current: Current,
    val forecast: Forecast
)

@Serializable
data class Current(
    @SerialName("temp_c") val tempC: Double,
    val condition: Condition,
    @SerialName("feelslike_c") val feelslikeC: Double,
)

@Serializable
data class Condition(
    val text: String,
    val icon: String
)

@Serializable
data class Forecast(
    val forecastday: List<Forecastday>
)

@Serializable
data class Forecastday(
    val day: Day,
    val hour: List<Hour>
)

@Serializable
data class Day(
    @SerialName("avgtemp_c") val avgtempC: Double,
    val condition: Condition,
)

@Serializable
data class Hour(
    @SerialName("feelslike_c") val feelslikeC: Double,
    @SerialName("chance_of_rain") val chanceOfRain: Int,
)

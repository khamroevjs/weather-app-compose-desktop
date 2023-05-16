import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class Repository(
    private val apiKey: String,
    private val client: HttpClient = defaultHttpClient,
) {
    private val transformer = WeatherTransformer()

    private suspend fun getWeatherForCity(city: String): WeatherResponse =
        client.get(
            "https://api.weatherapi.com/v1/forecast.json" +
                    "?key=$apiKey" +
                    "&q=$city" +
                    "&days=5" +
                    "&aqi=no" +
                    "&alerts=no"
        ).body()

    suspend fun weatherForCity(city: String): Lce<WeatherResults> {
        return try {
            val result = getWeatherForCity(city)
            val content = transformer.transform(result)
            Lce.Content(content)
        } catch (e: Exception) {
            e.printStackTrace()
            Lce.Error(e)
        }
    }

    companion object {
        val defaultHttpClient = HttpClient(CIO) {
            install(ContentNegotiation) {
                json(
                    Json { ignoreUnknownKeys = true }
                )
            }
        }
    }
}

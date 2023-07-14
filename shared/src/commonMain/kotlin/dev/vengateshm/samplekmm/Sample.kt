package dev.vengateshm.samplekmm

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDate
import kotlinx.datetime.TimeZone
import kotlinx.datetime.daysUntil
import kotlinx.datetime.todayIn
import kotlinx.serialization.json.Json
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class Sample : KoinComponent {
    private val platform: Platform = getPlatform()

    private val preferenceStorageProvider: PreferenceStorageProvider by inject()

    private val httpClient = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })
        }
    }

    private fun daysUntilNewYear(): Int {
        val today = Clock.System.todayIn(TimeZone.currentSystemDefault())
        val nextClosestYear = LocalDate(today.year + 1, 1, 1)
        return today.daysUntil(nextClosestYear)
    }

    @Throws(Exception::class)
    suspend fun getSampleText(): String {
        val rockets: List<RocketLaunch> =
            httpClient.get("https://api.spacexdata.com/v4/launches").body()
        val lastSuccessLaunch = rockets.last { it.launchSuccess == true }
        return "Hello, ${platform.name}!\n" +
                "${daysUntilNewYear()} more days for new year\n" +
                "${preferenceStorageProvider.getInt("latest_sdk_version")}" +
                "\nThe last successful launch was ${lastSuccessLaunch.launchDateUTC} 🚀"
    }
}
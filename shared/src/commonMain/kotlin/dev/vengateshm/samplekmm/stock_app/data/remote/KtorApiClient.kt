package dev.vengateshm.samplekmm.stock_app.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.header
import io.ktor.client.request.parameter
import io.ktor.http.path
import io.ktor.http.takeFrom
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

object KtorApiClient {

    private const val BASE_URL = "https://twelve-data1.p.rapidapi.com/"
    private const val API_KEY = ""
    private const val KEY_PARAMS_FORMAT = "key"
    private const val VALUE_PARAMS_FORMAT = "json"

    val client by lazy {
        HttpClient {
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                    useAlternativeNames = false
                })
            }
        }
    }

    fun HttpRequestBuilder.endPoint(path: String) {
        url {
            takeFrom(BASE_URL)
            path(path)
            parameter(KEY_PARAMS_FORMAT, VALUE_PARAMS_FORMAT)
            header("X-RapidAPI-Key", API_KEY)
            header("X-RapidAPI-Host", "twelve-data1.p.rapidapi.com")
        }
    }
}
package dev.vengateshm.samplekmm.stock_app.data.remote

import dev.vengateshm.samplekmm.stock_app.data.model.StockExchangeListResponseDto
import dev.vengateshm.samplekmm.stock_app.data.remote.KtorApiClient.endPoint
import io.ktor.client.call.body
import io.ktor.client.request.get

class StockApiService {
    suspend fun getAllStockExchangesList(): StockExchangeListResponseDto =
        KtorApiClient.client.get {
                endPoint("exchanges")
            }.body()
}
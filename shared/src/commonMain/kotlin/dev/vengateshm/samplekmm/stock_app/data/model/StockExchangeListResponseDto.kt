package dev.vengateshm.samplekmm.stock_app.data.model

import kotlinx.serialization.Serializable

@Serializable
data class StockExchangeListResponseDto(
    val data: List<StockExchangeDto>,
    val status: String,
)

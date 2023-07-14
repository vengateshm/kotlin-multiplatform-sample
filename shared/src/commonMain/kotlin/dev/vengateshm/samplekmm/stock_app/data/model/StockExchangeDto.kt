package dev.vengateshm.samplekmm.stock_app.data.model

import kotlinx.serialization.Serializable

@Serializable
data class StockExchangeDto(
    val name: String,
    val code: String,
    val country: String,
    val timezone: String,
)

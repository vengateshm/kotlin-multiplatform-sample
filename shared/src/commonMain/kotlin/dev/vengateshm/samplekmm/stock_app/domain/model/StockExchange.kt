package dev.vengateshm.samplekmm.stock_app.domain.model

data class StockExchange(
    val name: String,
    val code: String,
    val country: String,
    val timezone: String,
)

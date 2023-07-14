package dev.vengateshm.samplekmm.stock_app.domain.repository

import dev.vengateshm.samplekmm.stock_app.domain.model.StockExchange

interface StockAppRepository {
    suspend fun getAllStockExchangesList(): List<StockExchange>
}
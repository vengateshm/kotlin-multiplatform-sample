package dev.vengateshm.samplekmm.stock_app.data.util

import dev.vengateshm.samplekmm.stock_app.data.model.StockExchangeDto
import dev.vengateshm.samplekmm.stock_app.domain.model.StockExchange

fun StockExchangeDto.toStockExchange(): StockExchange {
    return StockExchange(
        name = name,
        code = code,
        country = country,
        timezone = timezone,
    )
}
package dev.vengateshm.samplekmm.shared.cache

import dev.vengateshm.samplekmm.stock_app.domain.model.StockExchange

internal class DatabaseClass(databaseDriverFactory: DatabaseDriverFactory) {
    private val database = AppDatabase(databaseDriverFactory.createDriver())
    private val dbQuery = database.appDatabaseQueries

    internal fun createStockExchanges(stockExchanges: List<StockExchange>) {
        dbQuery.transaction {
            stockExchanges.forEach { stockExchange ->
                addStockExchange(stockExchange)
            }
        }
    }

    private fun addStockExchange(stockExchange: StockExchange) {
        dbQuery.insertStockExchange(
            name = stockExchange.name,
            code = stockExchange.code,
            country = stockExchange.country,
            timezone = stockExchange.timezone
        )
    }

    internal fun getAllStockExchangesList(): List<StockExchange> {
        return dbQuery.selectAllStockExchangesInfo(::mapStockExchangeSelecting).executeAsList()
    }

    private fun mapStockExchangeSelecting(
        name: String,
        code: String,
        country: String,
        timezone: String?,
    ): StockExchange {
        return StockExchange(
            name = name, code = code, country = country, timezone = timezone ?: ""
        )
    }

    internal fun clearDatabase() {
        dbQuery.transaction {
            dbQuery.removeAllStockExchanges()
        }
    }
}
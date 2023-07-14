package dev.vengateshm.samplekmm.stock_app.data.repository

import dev.vengateshm.samplekmm.shared.cache.DatabaseClass
import dev.vengateshm.samplekmm.shared.cache.DatabaseDriverFactory
import dev.vengateshm.samplekmm.stock_app.data.remote.RemoteDataSource
import dev.vengateshm.samplekmm.stock_app.data.util.toStockExchange
import dev.vengateshm.samplekmm.stock_app.domain.model.StockExchange
import dev.vengateshm.samplekmm.stock_app.domain.repository.StockAppRepository

class StockApiRepositoryImpl(
    private val remoteDataSource: RemoteDataSource,
    private val databaseDriverFactory: DatabaseDriverFactory,
) : StockAppRepository {

    private val database = DatabaseClass(databaseDriverFactory)

    override suspend fun getAllStockExchangesList(): List<StockExchange> {
        val cachedStockExchanges = database.getAllStockExchangesList()
        println("Cached data : $cachedStockExchanges")
        return cachedStockExchanges.ifEmpty {
            remoteDataSource.getAllStockExchangesList().data.map { it.toStockExchange() }.also {
                database.clearDatabase()
                database.createStockExchanges(it)
            }
        }
    }
}
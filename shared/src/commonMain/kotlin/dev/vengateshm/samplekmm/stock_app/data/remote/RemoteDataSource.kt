package dev.vengateshm.samplekmm.stock_app.data.remote

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext

class RemoteDataSource(
    private val apiService: StockApiService,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
) {
    suspend fun getAllStockExchangesList() = withContext(dispatcher) {
        apiService.getAllStockExchangesList()
    }
}
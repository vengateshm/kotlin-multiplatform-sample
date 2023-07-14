package dev.vengateshm.samplekmm.stock_app.domain.usecase

import dev.vengateshm.samplekmm.stock_app.domain.model.StockExchange
import dev.vengateshm.samplekmm.stock_app.domain.repository.StockAppRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetAllStockExchangesListUseCase : KoinComponent {

    private val repository: StockAppRepository by inject()

    @Throws(Exception::class)
    suspend operator fun invoke(): List<StockExchange> {
        return repository.getAllStockExchangesList()
    }
}
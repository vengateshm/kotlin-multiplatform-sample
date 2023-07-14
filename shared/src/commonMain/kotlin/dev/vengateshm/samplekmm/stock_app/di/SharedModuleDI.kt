package dev.vengateshm.samplekmm.stock_app.di

import dev.vengateshm.samplekmm.stock_app.data.remote.RemoteDataSource
import dev.vengateshm.samplekmm.stock_app.data.remote.StockApiService
import dev.vengateshm.samplekmm.stock_app.data.repository.StockApiRepositoryImpl
import dev.vengateshm.samplekmm.stock_app.domain.repository.StockAppRepository
import dev.vengateshm.samplekmm.stock_app.domain.usecase.GetAllStockExchangesListUseCase
import org.koin.dsl.module

private val dataLayerModule = module {
    factory { RemoteDataSource(get()) }
    factory { StockApiService() }
}

private val domainLayerModule = module {
    single<StockAppRepository> { StockApiRepositoryImpl(get(),get()) }
    factory { GetAllStockExchangesListUseCase() }
}

fun sharedModules() = listOf(dataLayerModule, domainLayerModule)
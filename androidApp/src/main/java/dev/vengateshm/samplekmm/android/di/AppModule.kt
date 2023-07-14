package dev.vengateshm.samplekmm.android.di

import dev.vengateshm.samplekmm.AndroidPreferenceProviderImpl
import dev.vengateshm.samplekmm.PreferenceStorageProvider
import dev.vengateshm.samplekmm.android.presentation.home.HomeViewModel
import dev.vengateshm.samplekmm.shared.cache.DatabaseDriverFactory
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val appModule = module {
    viewModel { HomeViewModel(get()) }
    //single<PreferenceStorageProvider> { AndroidPreferenceProviderImpl(androidContext()) }
    singleOf(::AndroidPreferenceProviderImpl) { bind<PreferenceStorageProvider>() }
    single<DatabaseDriverFactory> { DatabaseDriverFactory(androidContext()) }
}
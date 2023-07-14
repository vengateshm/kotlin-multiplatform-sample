package dev.vengateshm.samplekmm.android

import android.app.Application
import dev.vengateshm.samplekmm.android.di.appModule
import dev.vengateshm.samplekmm.stock_app.di.sharedModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MySampleKMMApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MySampleKMMApp)
            modules(appModule + sharedModules())
        }
    }
}
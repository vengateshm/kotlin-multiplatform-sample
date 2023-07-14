package dev.vengateshm.samplekmm

class IosPreferenceProviderImpl : PreferenceStorageProvider {
    override fun getInt(key: String): Int {
        return -1
    }

    override fun putInt(key: String, value: Int) {

    }
}
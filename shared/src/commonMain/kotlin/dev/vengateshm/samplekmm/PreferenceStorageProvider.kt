package dev.vengateshm.samplekmm

interface PreferenceStorageProvider {
    fun getInt(key: String): Int
    fun putInt(key: String, value: Int)
}
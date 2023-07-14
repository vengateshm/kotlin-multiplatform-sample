package dev.vengateshm.samplekmm

expect abstract class PreferenceStorage

expect fun PreferenceStorage.getInt(key: String): Int
expect fun PreferenceStorage.putInt(key: String, value: Int)
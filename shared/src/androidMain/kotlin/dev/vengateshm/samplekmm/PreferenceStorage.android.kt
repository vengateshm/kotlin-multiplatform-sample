package dev.vengateshm.samplekmm

import android.content.Context

actual typealias PreferenceStorage = Context

actual fun PreferenceStorage.getInt(key: String): Int {
    return this.getSharedPreferences("", Context.MODE_PRIVATE).getInt(key, -1)
}

actual fun PreferenceStorage.putInt(key: String, value: Int) {
    this.getSharedPreferences("", Context.MODE_PRIVATE)
        .also {
            val editor = it.edit()
            editor.putInt(key, value)
            editor.apply()
        }
}
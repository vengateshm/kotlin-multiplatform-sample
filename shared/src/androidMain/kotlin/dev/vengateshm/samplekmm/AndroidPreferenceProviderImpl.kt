package dev.vengateshm.samplekmm

import android.content.Context

class AndroidPreferenceProviderImpl(private val context: Context) : PreferenceStorageProvider {

    override fun getInt(key: String): Int {
        return context.getSharedPreferences("", Context.MODE_PRIVATE).getInt(key, -1)
    }

    override fun putInt(key: String, value: Int) {
        context.getSharedPreferences("", Context.MODE_PRIVATE)
            .also {
                val editor = it.edit()
                editor.putInt(key, value)
                editor.apply()
            }
    }
}
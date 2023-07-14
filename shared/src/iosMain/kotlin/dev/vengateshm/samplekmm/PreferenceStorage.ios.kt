package dev.vengateshm.samplekmm

import platform.Foundation.NSUserDefaults
import platform.darwin.NSObject

actual typealias PreferenceStorage = NSObject

actual fun PreferenceStorage.getInt(key: String) : Int {
    return NSUserDefaults.standardUserDefaults.integerForKey(key).toInt()
}

actual fun PreferenceStorage.putInt(key: String, value : Int){
    NSUserDefaults.standardUserDefaults.setInteger(value.toLong(),key)
}
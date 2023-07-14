package dev.vengateshm.samplekmm

import org.junit.Assert.assertTrue
import org.junit.Test

class AndroidSampleTest {

    @Test
    fun testExample() {
        assertTrue("Check Android is mentioned", Sample().message().contains("Android"))
    }
}
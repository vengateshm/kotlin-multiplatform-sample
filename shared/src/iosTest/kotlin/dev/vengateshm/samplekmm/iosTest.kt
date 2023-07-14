package dev.vengateshm.samplekmm

import kotlin.test.Test
import kotlin.test.assertTrue

class IosGreetingTest {

    @Test
    fun testExample() {
        assertTrue(Sample().message().contains("iOS"), "Check iOS is mentioned")
    }
}
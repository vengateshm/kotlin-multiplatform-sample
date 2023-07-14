package dev.vengateshm.samplekmm

import kotlin.test.Test
import kotlin.test.assertTrue

class CommonGreetingTest {

    @Test
    fun testExample() {
        assertTrue(Sample().message().contains("Hello"), "Check 'Hello' is mentioned")
    }
}
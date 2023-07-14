package dev.vengateshm.samplekmm

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
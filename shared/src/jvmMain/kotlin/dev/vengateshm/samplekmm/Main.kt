package dev.vengateshm.samplekmm

import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val repo = StarWarsRepository()
    val films = repo.getFilms()
    films.forEach(::println)
}
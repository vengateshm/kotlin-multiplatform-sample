package dev.vengateshm.samplekmm.star_wars

import dev.vengateshm.samplekmm.fragment.FilmFragment

data class Film(val id: String, val title: String, val director: String, val openingCrawl: String)

fun FilmFragment.toModel() =
    Film(
        id = this.id,
        title = this.title ?: "",
        director = this.director ?: "",
        openingCrawl = this.openingCrawl ?: ""
    )

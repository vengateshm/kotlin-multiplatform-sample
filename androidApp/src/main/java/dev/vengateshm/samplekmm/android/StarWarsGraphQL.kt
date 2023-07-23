package dev.vengateshm.samplekmm.android

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.vengateshm.samplekmm.StarWarsRepository
import dev.vengateshm.samplekmm.star_wars.Film

@Composable
fun StarWarsFilm() {
    val repository = remember { StarWarsRepository() }

    var filmList by remember { mutableStateOf(emptyList<Film>()) }

    LaunchedEffect(key1 = true) {
        filmList = repository.getFilms()
    }

    if (filmList.isNotEmpty()) {
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(filmList) { film ->
                Card(
                    elevation = 8.dp,
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    ) {
                        Text(
                            text = film.title,
                            fontSize = 16.sp
                        )
                        Text(
                            text = film.director,
                            fontSize = 14.sp
                        )
                        Text(
                            text = film.openingCrawl,
                            fontSize = 12.sp
                        )
                    }
                }
            }
        }
    }
}
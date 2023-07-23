package dev.vengateshm.samplekmm

import com.apollographql.apollo3.ApolloClient
import dev.vengateshm.samplekmm.star_wars.Film
import dev.vengateshm.samplekmm.star_wars.toModel
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class StarWarsRepository {
    // ./gradlew downloadApolloSchema --endpoint=https://swapi-graphql.netlify.app/.netlify/functions/index --schema="shared/src/commonMain/graphql/schema.json"
    private val apolloClient = ApolloClient.Builder()
        .serverUrl("https://swapi-graphql.netlify.app/.netlify/functions/index")
        .build()

    suspend fun getFilms(): List<Film> {
        val response = apolloClient.query(GetAllFilmsQuery())
        return response.execute().dataAssertNoErrors.allFilms?.films?.mapNotNull { it?.filmFragment?.toModel() }
            ?: emptyList()
    }

    // Used by iOS client
    private val scope = MainScope()

    fun getFilms(success: (List<Film>) -> Unit) {
        scope.launch {
            success(getFilms())
        }
    }
}
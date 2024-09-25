package effective.android.labs.network

import effective.android.labs.presentation.model.MarvelCharacter

class MarvelRepository {
    private val apiService = RetrofitClient.apiService

    suspend fun getCharacters(): List<MarvelCharacter> {
        return apiService.getCharacters().data.results
    }

    suspend fun getCharacter(characterId: Int): MarvelCharacter {
        return apiService.getCharacter(characterId).data.results.first()
    }
}
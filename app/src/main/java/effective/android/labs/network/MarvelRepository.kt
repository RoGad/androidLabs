package effective.android.labs.network

import effective.android.labs.constants.SecretData.PRIVATE_KEY
import effective.android.labs.constants.SecretData.PUBLIC_KEY
import effective.android.labs.presentation.model.MarvelCharacter
import java.math.BigInteger

class MarvelRepository {
    private val apiService = RetrofitClient.apiService

    suspend fun getCharacters(): List<MarvelCharacter> {
        return apiService.getCharacters().data.results
    }

    suspend fun getCharacter(characterId: Int): MarvelCharacter {
        return apiService.getCharacter(characterId).data.results.first()
    }
}
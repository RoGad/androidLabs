package effective.android.labs.network

import effective.android.labs.presentation.model.MarvelCharacter
import effective.android.labs.presentation.model.MarvelResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MarvelApiService {
    @GET("v1/public/characters")
    suspend fun getCharacters(
        @Query("limit") limit: Int = 100
    ): MarvelResponse<MarvelCharacter>

    @GET("v1/public/characters/{characterId}")
    suspend fun getCharacter(
        @Path("characterId") characterId: Int
    ): MarvelResponse<MarvelCharacter>
}

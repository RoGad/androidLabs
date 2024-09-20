package effective.android.labs.network

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MarvelResponse(
    @Json(name = "data") val data: MarvelData
)

@JsonClass(generateAdapter = true)
data class MarvelData(
    @Json(name = "results") val results: List<MarvelCharacter>
)

@JsonClass(generateAdapter = true)
data class MarvelCharacter(
    @Json(name = "id") val id: Int,
    @Json(name = "name") val name: String,
    @Json(name = "description") val description: String,
    @Json(name = "thumbnail") val thumbnail: MarvelImage
)

@JsonClass(generateAdapter = true)
data class MarvelImage(
    @Json(name = "path") val path: String,
    @Json(name = "extension") val extension: String
)
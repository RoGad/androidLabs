package effective.android.labs.presentation.model

import com.squareup.moshi.Json

data class MarvelResponse<T>(
    @Json(name = "data") val data: MarvelData<T>
)

data class MarvelData<T>(
    @Json(name = "results") val results: List<T>
)

data class MarvelCharacter(
    @Json(name = "id") val id: Int,
    @Json(name = "name") val name: String,
    @Json(name = "description") val description: String,
    @Json(name = "thumbnail") val thumbnail: MarvelImage
)

data class MarvelImage(
    @Json(name = "path") val path: String,
    @Json(name = "extension") val extension: String
)
package effective.android.labs.data

import androidx.room.Entity
import androidx.room.PrimaryKey

data class CharacterDTO(
    val id: Int,
    val name: String,
    val description: String,
    val thumbnail: ThumbnailDTO
)

data class ThumbnailDTO(
    val path: String,
    val extension: String
)

data class CharacterUI(
    val id: Int,
    val name: String,
    val description: String,
    val imageUrl: String
)

@Entity(tableName = "characters")
data class CharacterEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val description: String,
    val thumbnailPath: String,
    val thumbnailExtension: String
)

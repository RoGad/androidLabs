package effective.android.labs.data

object CharacterMapper {
    fun dtoToUi(dto: CharacterDTO): CharacterUI = CharacterUI(
        id = dto.id,
        name = dto.name,
        description = dto.description,
        imageUrl = "${dto.thumbnail.path}.${dto.thumbnail.extension}"
    )

    fun entityToUi(entity: CharacterEntity): CharacterUI = CharacterUI(
        id = entity.id,
        name = entity.name,
        description = entity.description,
        imageUrl = "${entity.thumbnailPath}.${entity.thumbnailExtension}"
    )

    fun dtoToEntity(dto: CharacterDTO): CharacterEntity = CharacterEntity(
        id = dto.id,
        name = dto.name,
        description = dto.description,
        thumbnailPath = dto.thumbnail.path,
        thumbnailExtension = dto.thumbnail.extension
    )
}

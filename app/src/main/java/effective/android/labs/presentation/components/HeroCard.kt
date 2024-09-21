package effective.android.labs.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import effective.android.labs.constants.heroCardTextPadding
import effective.android.labs.constants.roundedCornerShapeHeroCard
import effective.android.labs.presentation.model.MarvelCharacter
import effective.android.labs.presentation.theme.Typography

@Composable
fun HeroCard(modifier: Modifier = Modifier, hero: MarvelCharacter, onHeroClick: (MarvelCharacter) -> Unit) {
    ElevatedCard(
        modifier = modifier,
        shape = roundedCornerShapeHeroCard,
        onClick = { onHeroClick(hero) },
        elevation = CardDefaults.cardElevation(
            defaultElevation = 5.dp
        )
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data("${hero.thumbnail.path}/standard_large.${hero.thumbnail.extension}")
                    .crossfade(true)
                    .build(),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(heroCardTextPadding),
                contentAlignment = Alignment.BottomStart
            ) {
                Text(
                    text = hero.name,
                    style = Typography.bodyMedium
                )
            }
        }
    }
}

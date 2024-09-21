package effective.android.labs.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import effective.android.labs.constants.copyColor
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
            HeroImage(
                imageUrl = "${hero.thumbnail.path}.${hero.thumbnail.extension}",
                contentDescription = hero.name,
                modifier = Modifier.fillMaxSize()
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .background(color = Color.Black.copy(copyColor))
            ) {
                Text(
                    text = hero.name,
                    style = Typography.bodyLarge,
                    color = Color.White,
                    modifier = Modifier
                        .padding(heroCardTextPadding)
                        .align(Alignment.BottomCenter)
                )
            }
        }
    }
}

package effective.android.labs.presentation.components

import androidx.compose.foundation.Image
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import effective.android.labs.constants.heroCardTextPadding
import effective.android.labs.constants.roundedCornerShapeHeroCard
import effective.android.labs.presentation.model.HeroData
import effective.android.labs.presentation.theme.Typography

@Composable
fun HeroCard(modifier: Modifier = Modifier, heroData: HeroData, onHeroClick: (HeroData) -> Unit) {
    ElevatedCard(
        modifier = modifier,
        shape = roundedCornerShapeHeroCard,
        onClick = { onHeroClick(heroData) },
        elevation = CardDefaults.cardElevation(
            defaultElevation = 5.dp
        )
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(heroData.imageId),
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
                    text = heroData.name,
                    style = Typography.bodyMedium
                )
            }
        }
    }
}

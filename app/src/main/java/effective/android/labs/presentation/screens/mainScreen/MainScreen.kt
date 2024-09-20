package effective.android.labs.presentation.screens.mainScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import effective.android.labs.R
import effective.android.labs.constants.logoMarvelSize
import effective.android.labs.presentation.components.HeroListCard
import effective.android.labs.presentation.components.RightTriangle
import effective.android.labs.presentation.model.HeroData
import effective.android.labs.presentation.theme.Typography
import effective.android.labs.presentation.viewModel.HeroSelectionViewModel

@Composable
fun HeroSelectionScreen(viewModel: HeroSelectionViewModel, onHeroClick: (HeroData) -> Unit) {
    Box(modifier = Modifier.fillMaxSize()) {

        val triangleColor = viewModel.heroes[viewModel.currentHeroIndex.value].triangleColor
        RightTriangle(color = triangleColor)

        Image(
            painter = painterResource(id = R.drawable.ic_marvel_studios),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .size(logoMarvelSize)
        )

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(
                text = stringResource(id = R.string.choose_your_hero),
                style = Typography.bodyLarge
            )
            HeroListCard(viewModel = viewModel, onHeroClick = onHeroClick)
        }
    }
}

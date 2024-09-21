package effective.android.labs.presentation.screens.mainScreen

import android.graphics.Color
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import effective.android.labs.R
import effective.android.labs.constants.logoMarvelSize
import effective.android.labs.presentation.model.MarvelCharacter
import effective.android.labs.presentation.components.HeroListCard
import effective.android.labs.presentation.components.RightTriangle
import effective.android.labs.presentation.components.randomColor
import effective.android.labs.presentation.theme.Typography
import effective.android.labs.presentation.viewModel.HeroSelectionViewModel
import kotlin.random.Random

@Composable
fun HeroSelectionScreen(viewModel: HeroSelectionViewModel, onHeroClick: (MarvelCharacter) -> Unit) {
    val triangleColor = remember { mutableStateOf(randomColor()) }

    Box(modifier = Modifier.fillMaxSize()) {
        RightTriangle(color = triangleColor.value)
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
            HeroListCard(
                viewModel = viewModel,
                onHeroClick = onHeroClick,
                onItemChanged = { triangleColor.value = randomColor() }
            )
        }
    }
}

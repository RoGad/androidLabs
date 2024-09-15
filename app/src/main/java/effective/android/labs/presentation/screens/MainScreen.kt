package effective.android.labs.presentation.screens

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import effective.android.labs.R
import effective.android.labs.presentation.components.HeroCard
import effective.android.labs.presentation.components.RightTriangle
import effective.android.labs.presentation.theme.White
import effective.android.labs.presentation.viewModel.HeroSelectionViewModel
import kotlin.math.abs

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HeroSelectionScreen(viewModel: HeroSelectionViewModel) {
    val lazyListState = rememberLazyListState()

    val snapBehavior = rememberSnapFlingBehavior(lazyListState = lazyListState)

    val currentItem by remember {
        derivedStateOf {
            lazyListState.layoutInfo.visibleItemsInfo.minByOrNull { abs(it.offset) }?.index ?: 0
        }
    }

    LaunchedEffect(currentItem) {
        viewModel.updateCurrentHeroIndex(currentItem)
    }

    Box(modifier = Modifier.fillMaxSize()) {

        val triangleColor = viewModel.heroes[viewModel.currentHeroIndex.value].triangleColor
        RightTriangle(color = triangleColor)

        Image(
            painter = painterResource(id = R.drawable.ic_marvel_studios),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .size(110.dp)
        )

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(
                text = stringResource(id = R.string.choose_your_hero),
                style = TextStyle(
                    color = White,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            LazyRow(
                state = lazyListState,
                flingBehavior = snapBehavior,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(500.dp),
                contentPadding = PaddingValues(horizontal = 40.dp),
                horizontalArrangement = Arrangement.spacedBy(40.dp)
            ) {
                itemsIndexed(viewModel.heroes) { index, hero ->
                    val scale by animateFloatAsState(
                        targetValue = if (index == currentItem) 1.1f else 1f,
                        animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy)
                    )
                    HeroCard(
                        heroData = hero,
                        modifier = Modifier
                            .scale(scale)
                    )
                }
            }
        }
    }
}



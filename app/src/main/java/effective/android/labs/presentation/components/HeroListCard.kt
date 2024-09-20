package effective.android.labs.presentation.components

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.unit.dp
import effective.android.labs.R
import effective.android.labs.constants.contentListRowHeroPadding
import effective.android.labs.presentation.model.HeroData
import effective.android.labs.presentation.viewModel.HeroSelectionViewModel
import kotlin.math.abs

@Composable
fun HeroListCard(viewModel: HeroSelectionViewModel, onHeroClick: (HeroData) -> Unit) {
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

    LazyRow(
        state = lazyListState,
        flingBehavior = snapBehavior,
        modifier = Modifier
            .fillMaxWidth()
            .height(500.dp),
        contentPadding = contentListRowHeroPadding,
        horizontalArrangement = Arrangement.spacedBy(40.dp)
    ) {
        itemsIndexed(viewModel.heroes) { index, hero ->
            val scale by animateFloatAsState(
                targetValue = if (index == currentItem) 1.1f else 1f,
                animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy),
                label = R.string.anim_card_bubble.toString()
            )
            HeroCard(
                heroData = hero,
                modifier = Modifier
                    .scale(scale),
                onHeroClick = onHeroClick
            )
        }
    }
}

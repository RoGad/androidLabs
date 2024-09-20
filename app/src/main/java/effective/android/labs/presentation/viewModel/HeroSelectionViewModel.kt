package effective.android.labs.presentation.viewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableIntStateOf
import androidx.lifecycle.ViewModel
import effective.android.labs.R
import effective.android.labs.presentation.model.HeroData
import effective.android.labs.presentation.theme.DarkRed
import effective.android.labs.presentation.theme.DarkYellow
import effective.android.labs.presentation.theme.RedDeadpool

class HeroSelectionViewModel : ViewModel() {
    val heroes = listOf(
        HeroData("Iron Man", R.drawable.ic_iron_man, "I AM IRON MAN", DarkRed),
        HeroData("Spider Man", R.drawable.ic_spider_card_image, "In iron suit", DarkYellow),
        HeroData("Deadpool", R.drawable.ic_deadpool, "Please don’t make the super suit green...or animated!", RedDeadpool)
    )

    private val _currentHeroIndex = mutableIntStateOf(0)
    val currentHeroIndex: State<Int> = _currentHeroIndex

    fun updateCurrentHeroIndex(index: Int) {
        _currentHeroIndex.intValue = index
    }
}

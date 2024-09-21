package effective.android.labs.presentation.viewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import effective.android.labs.R
import effective.android.labs.network.MarvelCharacter
import effective.android.labs.network.MarvelRepository
import effective.android.labs.presentation.model.HeroData
import effective.android.labs.presentation.theme.DarkRed
import effective.android.labs.presentation.theme.DarkYellow
import effective.android.labs.presentation.theme.RedDeadpool
import kotlinx.coroutines.launch

class HeroSelectionViewModel : ViewModel() {
    private val repository = MarvelRepository()

    private val _heroes = mutableStateOf<List<MarvelCharacter>>(emptyList())
    val heroes: State<List<MarvelCharacter>> = _heroes

    private val _currentHeroIndex = mutableStateOf(0)
    val currentHeroIndex: State<Int> = _currentHeroIndex

    private val _errorMessage = mutableStateOf<String?>(null)
    val errorMessage: State<String?> = _errorMessage

    init {
        loadHeroes()
    }

    private fun loadHeroes() {
        viewModelScope.launch {
            try {
                _heroes.value = repository.getCharacters()
            } catch (e: Exception) {
                _errorMessage.value = "Failed to load heroes: ${e.message}"
            }
        }
    }

    fun updateCurrentHeroIndex(index: Int) {
        _currentHeroIndex.value = index
    }

    fun getHeroById(id: Int): MarvelCharacter? {
        return heroes.value.find { it.id == id }
    }
}

package effective.android.labs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import effective.android.labs.presentation.screens.HeroSelectionScreen
import effective.android.labs.presentation.theme.AnroidLabsTheme
import effective.android.labs.presentation.viewModel.HeroSelectionViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AnroidLabsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.secondary
                ) {
                    val viewModel: HeroSelectionViewModel = viewModel()
                    HeroSelectionScreen(viewModel)
                }
            }
        }
    }
}

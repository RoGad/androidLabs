package effective.android.labs.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = darkPrimary,
    secondary = darkPrimary,
    background = darkCC,
    onSecondary = White
)

private val LightColorScheme = lightColorScheme(
    primary = Brown,
    secondary = Beige,
    background = Pink40,
    onSecondary = Color.Black
)

@Composable
fun AnroidLabsTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorScheme
    } else {
        LightColorScheme
    }

    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        content = content
    )
}
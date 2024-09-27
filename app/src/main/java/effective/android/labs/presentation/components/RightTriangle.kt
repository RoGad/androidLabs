package effective.android.labs.presentation.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.tooling.preview.Preview
import effective.android.labs.presentation.theme.DarkRed
import kotlin.random.Random

@Composable
fun RightTriangle(color: Color) {
    Canvas(modifier = Modifier.fillMaxSize()) {
        val canvasWidth = size.width
        val canvasHeight = size.height
        val triangleHeight = canvasHeight / 2

        val trianglePath = Path().apply {
            moveTo(canvasWidth, canvasHeight - triangleHeight)
            lineTo(canvasWidth, canvasHeight)
            lineTo(0f, canvasHeight)
            close()
        }
        drawPath(
            path = trianglePath,
            color = color
        )
    }
}

fun randomColor(): Color {
    return Color(
        red = Random.nextFloat(),
        green = Random.nextFloat(),
        blue = Random.nextFloat(),
        alpha = 1f
    )
}
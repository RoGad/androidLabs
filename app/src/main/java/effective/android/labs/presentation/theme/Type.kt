package effective.android.labs.presentation.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val Typography = Typography(
    bodyLarge = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 28.sp,
        color = White
    ),
    titleLarge = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 40.sp,
        color = White
    ),
    labelSmall = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp,
        color = White.copy(0.7f)
    ),
    bodyMedium = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp,
        color = White
    )
)

package effective.android.labs.presentation.screens.heroInfoScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import effective.android.labs.constants.copyColor
import effective.android.labs.constants.heroInfoDescriptionPaddingAll
import effective.android.labs.constants.heroInfoNamePaddingStart
import effective.android.labs.constants.iconButtonPaddingStart
import effective.android.labs.constants.sizeIconArrowBack
import effective.android.labs.presentation.components.HeroImage
import effective.android.labs.presentation.model.MarvelCharacter
import effective.android.labs.presentation.theme.Typography
import effective.android.labs.presentation.theme.White

@Composable
fun HeroInfoScreen(hero: MarvelCharacter, onBackClick: () -> Unit) {
    Box(modifier = Modifier.fillMaxSize()) {
        HeroImage(
            imageUrl = "${hero.thumbnail.path}.${hero.thumbnail.extension}",
            contentDescription = hero.name,
            modifier = Modifier.fillMaxSize()
        )
        Column(
            Modifier.fillMaxSize().background(color = Color.Black.copy(copyColor)),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = hero.name,
                style = Typography.titleLarge,
                modifier = Modifier
                    .padding(heroInfoNamePaddingStart)
            )
            Text(
                text = hero.description.ifEmpty { "No description available." },
                style = Typography.labelSmall,
                modifier = Modifier
                    .padding(heroInfoDescriptionPaddingAll)
            )
        }
        IconButton(
            onClick = onBackClick,
            modifier = Modifier
                .padding(iconButtonPaddingStart)
                .align(Alignment.TopStart)
                .size(sizeIconArrowBack)
        ) {
            Icon(
                modifier = Modifier.size(sizeIconArrowBack),
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = null,
                tint = White
            )
        }
    }
}

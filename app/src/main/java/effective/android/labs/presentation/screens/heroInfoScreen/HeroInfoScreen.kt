package effective.android.labs.presentation.screens.heroInfoScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import effective.android.labs.constants.heroInfoDescriptionPaddingAll
import effective.android.labs.constants.heroInfoNamePaddingStart
import effective.android.labs.constants.iconButtonPaddingStart
import effective.android.labs.presentation.model.HeroData
import effective.android.labs.presentation.theme.Typography
import effective.android.labs.presentation.theme.White

@Composable
fun HeroInfoScreen(heroInfo: HeroData, onBackClick: () -> Unit) {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(heroInfo.imageId),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        IconButton(
            onClick = onBackClick,
            modifier = Modifier
                .padding(iconButtonPaddingStart)
                .align(Alignment.TopStart)
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = null,
                tint = White
            )
        }
        Column(
            Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = heroInfo.name,
                style = Typography.titleLarge,
                modifier = Modifier
                    .padding(heroInfoNamePaddingStart)
            )
            Text(
                text = heroInfo.description,
                style = Typography.labelSmall,
                modifier = Modifier
                    .padding(heroInfoDescriptionPaddingAll)
            )

        }
    }
}

package effective.android.labs.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import effective.android.labs.presentation.model.HeroData
import effective.android.labs.presentation.theme.White

@Composable
fun HeroList(modifier: Modifier, heroData: HeroData) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(10.dp)
    ) {
        Image(
            painter = painterResource(heroData.imageId),
            contentDescription = null,
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primary)
                .fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Bottom
        ) {
            Text(
                text = heroData.name,
                style = TextStyle(
                    color = White,
                    fontSize = 32.sp
                )

            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHeroList() {
    HeroList(heroData = HeroData("Iron Man", 0, "Desc", 0), modifier = Modifier)
}
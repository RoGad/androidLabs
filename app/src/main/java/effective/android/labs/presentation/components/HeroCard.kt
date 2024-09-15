package effective.android.labs.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import effective.android.labs.R
import effective.android.labs.presentation.model.HeroData
import effective.android.labs.presentation.theme.DarkRed
import effective.android.labs.presentation.theme.White

@Composable
fun HeroCard(modifier: Modifier = Modifier, heroData: HeroData) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(10.dp),
        onClick = { }
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(heroData.imageId),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 30.dp, bottom = 50.dp),
                contentAlignment = Alignment.BottomStart
            ) {
                Text(
                    text = heroData.name,
                    style = TextStyle(
                        color = White,
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHeroCard(){
    HeroCard(modifier = Modifier, heroData = HeroData("Iron Man", R.drawable.ic_iron_man, DarkRed))
}



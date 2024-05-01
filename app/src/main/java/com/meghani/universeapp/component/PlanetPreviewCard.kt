package com.meghani.universeapp.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.meghani.universeapp.Planet
import com.meghani.universeapp.R
import com.meghani.universeapp.Route
import com.meghani.universeapp.getDefaultPlanet

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlanetPreviewCard(
    modifier: Modifier = Modifier,
    planet: Planet = getDefaultPlanet(),
    index: Int = 1,
    navController: NavController
) {
    Box(
        modifier = modifier
            .wrapContentSize(Alignment.Center)
    ) {
        Image(
            modifier = Modifier
                .size(150.dp)
                .zIndex(1f)
                .shadow(
                    elevation = 40.dp,
                    shape = RoundedCornerShape(100),
                    clip = false,
                    spotColor = Color(0xFF007AFF)

                )
                .align(Alignment.TopCenter),
            painter = painterResource(id = planet.image),
            contentDescription = ""
        )

        Image(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(top = 335.dp)
                .size(75.dp)
                .zIndex(1f),
            contentScale = ContentScale.Crop,
            painter = painterResource(id = R.drawable.copy_of_black_and_grey_minimalist_simple_modern_square_hipster_stone_logo__7_),
            contentDescription = ""
        )

        Card(
            modifier = Modifier
                .size(225.dp, 375.dp)
                .padding(top = 75.dp),
            shape = RoundedCornerShape(45.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White,
            ),
            onClick = { navController.navigate("${Route.DETAIL_PAGE}/${index}") }
        ) {
            Box(Modifier.fillMaxSize()) {
                Column(
                    modifier = Modifier.padding(end = 15.dp, start = 15.dp, top = 90.dp),
                ) {
                    Text(
                        text = planet.planetName,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily(Font(R.font.poppins_medium)),
                        style = MaterialTheme.typography.headlineLarge
                    )

                    Text(
                        text = planet.planetDescription,
                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                        style = MaterialTheme.typography.bodyLarge
                    )
                }

                Text(
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .padding(end = 10.dp),
                    text = (index + 1).toString(),
                    fontSize = 150.sp,
                    color = Color.Black.copy(alpha = 0.1f),
                    fontWeight = FontWeight.Bold,
                )
            }
        }
    }
}
package com.meghani.universeapp.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.meghani.universeapp.R
import com.meghani.universeapp.component.PlanetPreviewCard
import com.meghani.universeapp.loadPlanetList
import com.meghani.universeapp.pagerAnimation

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DashboardScreen(navController: NavController) {
    Box(modifier = with(Modifier) {
        fillMaxSize().paint(
            painterResource(id = R.drawable.copy_of_black_and_grey_minimalist_simple_modern_square_hipster_stone_logo__3_),
            contentScale = ContentScale.FillBounds
        )

    }) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 64.dp, start = 16.dp, end = 16.dp, bottom = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    modifier = Modifier.size(40.dp),
                    painter = painterResource(id = R.drawable.copy_of_black_and_grey_minimalist_simple_modern_square_hipster_stone_logo__12_),
                    contentDescription = "",
                    contentScale = ContentScale.Crop
                )

                Image(
                    modifier = Modifier.size(40.dp),
                    painter = painterResource(id = R.drawable.copy_of_black_and_grey_minimalist_simple_modern_square_hipster_stone_logo__8_),
                    contentDescription = "",
                    contentScale = ContentScale.Crop
                )
            }

            Text(
                text = "Space\n\nChronicles",
                fontSize = 40.sp,
                fontFamily = FontFamily(Font(R.font.poppins_bold)),
                color = Color.White,
                textAlign = TextAlign.Center
            )

            val planetList = loadPlanetList()

            val pagerState = rememberPagerState(
                initialPage = 0,
                initialPageOffsetFraction = 0f,
                pageCount = { planetList.size },
            )

            val screenWidth = LocalConfiguration.current.screenWidthDp
            val pageWidth = (screenWidth / 5f).dp
            HorizontalPager(
                modifier = Modifier.padding(top = 32.dp),
                state = pagerState,
                contentPadding = PaddingValues(horizontal = pageWidth),
                verticalAlignment = Alignment.CenterVertically,
                beyondBoundsPageCount = 3
            ) { thisPageIndex ->
                PlanetPreviewCard(
                    modifier = Modifier.pagerAnimation(
                        pagerState = pagerState,
                        thisPageIndex = thisPageIndex,
                    ), planet = planetList[thisPageIndex], index = thisPageIndex, navController
                )
            }

            Spacer(modifier = Modifier.weight(1f))
            Row(horizontalArrangement = Arrangement.spacedBy((-12).dp)) {
                Image(
                    modifier = Modifier
                        .size(40.dp),
                    contentScale = ContentScale.Crop,
                    painter = painterResource(id = R.drawable.copy_of_black_and_grey_minimalist_simple_modern_square_hipster_stone_logo__9_),
                    contentDescription = ""
                )
                Image(
                    modifier = Modifier
                        .size(40.dp),
                    contentScale = ContentScale.Crop,
                    painter = painterResource(id = R.drawable.copy_of_black_and_grey_minimalist_simple_modern_square_hipster_stone_logo__8_),
                    contentDescription = ""
                )
                Image(
                    modifier = Modifier
                        .size(40.dp),
                    contentScale = ContentScale.Crop,
                    painter = painterResource(id = R.drawable.copy_of_black_and_grey_minimalist_simple_modern_square_hipster_stone_logo__10_),
                    contentDescription = ""
                )
                Image(
                    modifier = Modifier
                        .size(40.dp),
                    contentScale = ContentScale.Crop,
                    painter = painterResource(id = R.drawable.copy_of_black_and_grey_minimalist_simple_modern_square_hipster_stone_logo__11_),
                    contentDescription = ""
                )
            }
            Text(
                modifier = Modifier.padding(bottom = 64.dp),
                text = "Ahmad, Meghani and 2 others are online",
                fontFamily = FontFamily(Font(R.font.poppins_regular)),
                style = MaterialTheme.typography.bodySmall,
                color = Color.White,
                textAlign = TextAlign.Center
            )

        }
    }
}
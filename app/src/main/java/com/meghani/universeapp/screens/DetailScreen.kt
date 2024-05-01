package com.meghani.universeapp.screens

import androidx.annotation.DrawableRes
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsBottomHeight
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
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
import com.meghani.universeapp.R
import com.meghani.universeapp.loadPlanetList

@Preview(showBackground = true)
@Composable
fun DetailScreen(
    index: Int = 0,
    modifier: Modifier = Modifier,
    navController: NavController = rememberNavController()
) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {

        val screenHeight = LocalConfiguration.current.screenHeightDp
        val planet = loadPlanetList().get(index)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(screenHeight.dp / 2.5f)
        ) {
            Image(
                modifier = Modifier
                    .padding(start = 16.dp, top = 64.dp)
                    .size(40.dp)
                    .clickable {
                        navController.popBackStack()
                    },
                painter = painterResource(id = R.drawable.copy_of_black_and_grey_minimalist_simple_modern_square_hipster_stone_logo__14_),
                contentDescription = "",
                contentScale = ContentScale.Crop
            )

            Text(
                modifier = Modifier
                    .padding(24.dp)
                    .align(Alignment.BottomStart),
                text = (index + 1).toString(),
                fontSize = 150.sp,
                color = Color.Black.copy(alpha = 0.1f),
                fontWeight = FontWeight.Bold,
            )

            AnimatedImage(image = planet.image, modifier = Modifier.align(Alignment.TopEnd))
        }

        Spacer(modifier = Modifier.weight(1f))

        Text(
            modifier = Modifier.padding(start = 16.dp, top = 16.dp),
            text = planet.planetName,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily(Font(R.font.poppins_medium)),
            style = MaterialTheme.typography.headlineLarge
        )

        Text(
            modifier = Modifier.padding(start = 16.dp, top = 8.dp, end = 16.dp, bottom = 8.dp),
            text = planet.longDescription,
            fontFamily = FontFamily(Font(R.font.poppins_regular)),
            style = MaterialTheme.typography.bodyLarge
        )


        Card(
            shape = RoundedCornerShape(15), modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 64.dp)
                .aspectRatio(1.8f)
        ) {
            Box {
                Image(
                    painter = painterResource(id = R.drawable.copy_of_black_and_grey_minimalist_simple_modern_square_hipster_stone_logo__1073_x_600_px_),
                    contentDescription = "",
                    contentScale = ContentScale.Crop
                )

                Spacer(
                    modifier = Modifier
                        .matchParentSize()
                        .background(Color.Black.copy(alpha = 0.4f))
                )

                Image(
                    modifier = Modifier
                        .size(100.dp)
                        .align(Alignment.Center),
                    painter = painterResource(id = R.drawable.copy_of_black_and_grey_minimalist_simple_modern_square_hipster_stone_logo__1000_x_500_px___3_),
                    contentDescription = ""
                )

            }

        }

    }


}

@Composable
fun AnimatedImage(@DrawableRes image: Int, modifier: Modifier = Modifier) {
    val scale = remember {
        Animatable(0.1f)
    }
    val animatedModifier = modifier.scale(scale.value)

    LaunchedEffect(Unit) {
        scale.animateTo(
            targetValue = 2.5f, animationSpec = tween(
                durationMillis = 500, easing = FastOutLinearInEasing
            )
        )
    }

    Image(
        painter = painterResource(id = image),
        contentDescription = null,
        modifier = animatedModifier,
        contentScale = ContentScale.Crop
    )
}
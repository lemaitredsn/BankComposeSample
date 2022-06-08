package ru.lemaitre.bankcomposesample.features.add_card

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import ru.lemaitre.bankcomposesample.R

@OptIn(ExperimentalPagerApi::class)
@Composable
@Preview
fun AddCardScreen() {
    val state = rememberPagerState()
    val slideImage = remember { mutableStateOf(R.drawable.ic_add_circle) }
    HorizontalPager(count = 3, state = state) { page ->
        when(page)  {

            0 -> {
                slideImage.value = R.drawable.ic_card
            }

            1 -> {
                slideImage.value = R.drawable.mastercard_icon
            }

            2 -> {
                slideImage.value = R.drawable.mir_icon
            }
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(top = 100.dp)
        ) {
            Image(
                painterResource(slideImage.value),
                contentDescription = ""
            )
        }

    }

    Spacer(modifier = Modifier.padding(4.dp))

    DotsIndicator(
        totalDots = 3,
        selectedIndex = state.currentPage,
        selectedColor = Color.Blue,
        unSelectedColor = Color.DarkGray
    )
}

@Composable
fun DotsIndicator(
    totalDots : Int,
    selectedIndex : Int,
    selectedColor: Color,
    unSelectedColor: Color,
){

    LazyRow(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .wrapContentHeight(),
        horizontalArrangement = Arrangement.Center
    ) {

        items(totalDots) { index ->
            if (index == selectedIndex) {
                Box(
                    modifier = Modifier
                        .size(10.dp)
                        .clip(CircleShape)
                        .background(selectedColor)
                )
            } else {
                Box(
                    modifier = Modifier
                        .size(10.dp)
                        .clip(CircleShape)
                        .background(unSelectedColor)
                )
            }

            if (index != totalDots - 1) {
                Spacer(modifier = Modifier.padding(horizontal = 2.dp))
            }
        }
    }
}
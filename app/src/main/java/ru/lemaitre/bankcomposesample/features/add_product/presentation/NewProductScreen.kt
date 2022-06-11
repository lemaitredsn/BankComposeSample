package ru.lemaitre.bankcomposesample.features.add_product.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import ru.lemaitre.bankcomposesample.features.add_product.domain.model.NewProductModel

@OptIn(ExperimentalPagerApi::class, androidx.compose.foundation.ExperimentalFoundationApi::class)
@Composable
fun NewProductScreen(viewModel: NewProductViewModel) {
    val variants = viewModel.productsVariants

    val state = rememberPagerState()
    HorizontalPager(count = variants.value.size, state = state) { page ->
        when (page) {
            page -> Tab(variants.value[page])
        }
    }

    DotsIndicator(
        totalDots = 3,
        selectedIndex = state.currentPage,
        selectedColor = Color.Blue,
        unSelectedColor = Color.DarkGray
    )
}

@Composable
fun Tab(newProductModel: NewProductModel) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(top = 20.dp)
    ) {
        Card(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            backgroundColor = Color.Cyan
        ) {
            Column {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp)
                        .weight(1f)
                ) {
                    Text(text = "Название", fontSize = 18.sp)
                    Text(text = newProductModel.name, fontSize = 24.sp)
                    Text(text = "Валюта", fontSize = 18.sp)
                    Text(text = newProductModel.currency, fontSize = 24.sp)
                    Text(text = "Срок", fontSize = 18.sp)
                    Text(text = newProductModel.term, fontSize = 24.sp)
                    Text(text = "Условия", fontSize = 18.sp)
                    Text(text = newProductModel.condition, fontSize = 24.sp)
                    Text(text = "Описание", fontSize = 18.sp)
                    Text(text = newProductModel.description, fontSize = 24.sp)
                }
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    Text(text = "Заказать")
                }
            }
        }

    }
}


@Composable
fun DotsIndicator(
    totalDots: Int,
    selectedIndex: Int,
    selectedColor: Color,
    unSelectedColor: Color,
) {

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
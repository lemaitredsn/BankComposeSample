package ru.lemaitre.bankcomposesample.features.main_screen.presentation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ru.lemaitre.bankcomposesample.R
import ru.lemaitre.bankcomposesample.common.domain.AccountProductModel
import ru.lemaitre.bankcomposesample.common.domain.CardProductModel
import ru.lemaitre.bankcomposesample.common.domain.Products

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ProductView(products: List<Products>) {

    var rotated by rememberSaveable { mutableStateOf(true) }

    val rotateExtra by animateFloatAsState(
        if (rotated) 90F else 0F
    )

    Row(verticalAlignment = Alignment.CenterVertically) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Column(modifier = Modifier.weight(1f)) {
                Row(modifier = Modifier.clickable { rotated = !rotated }) {
                    Text(stringResource(id = R.string.main_screen_cards))
                    Icon(
                        painter = painterResource(id = R.drawable.ic_arrow_right),
                        contentDescription = stringResource(id = R.string.main_screen_show_cards),
                        modifier = Modifier.rotate(rotateExtra)
                    )
                }
            }
            Column() {
                Icon(
                    painter = painterResource(id = R.drawable.ic_add_circle),
                    contentDescription = stringResource(id = R.string.main_screen_add_card)
                )
            }
        }
    }
    val scrollState = rememberLazyListState()

    AnimatedVisibility(
        visible = rotated,
        content = {
            LazyColumn(
                state = scrollState,
                contentPadding = PaddingValues(bottom = 70.dp),
            ) {
                items(
                    items = products,
                    itemContent = {
                        when (it) {
//                            is CardProductModel -> ProductItem(it)
//                            is AccountProductModel -> ProductItem(it)
                        }
                    }
                )
            }
        }
    )
}


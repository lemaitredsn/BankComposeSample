package ru.lemaitre.bankcomposesample.features.main_screen.presentation.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
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
import ru.lemaitre.bankcomposesample.common.domain.Products

@Composable
fun HeaderProducts(
    nameResource: Int,
    startShow: Boolean, //flag
    rotatedCallback: (Boolean) -> Unit,
    name: String,
    selected: (String) -> Unit

    ) { //fixme
    var rotate by rememberSaveable { mutableStateOf(startShow) }
    val rotateExtra by animateFloatAsState(
        if (rotate) 90F else 0F
    )
    Row(verticalAlignment = Alignment.CenterVertically) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Column(modifier = Modifier.weight(1f)) {
                Row(modifier = Modifier
                    .padding(8.dp)
                    .clickable {
                    rotate = !rotate
                    rotatedCallback(rotate)
                }) {
                    Text(
                        stringResource(id = nameResource)
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.ic_arrow_right),
                        contentDescription = stringResource(id = R.string.main_screen_show_cards),
                        modifier = Modifier.rotate(rotateExtra)
                    )
                }
            }
            Column(modifier = Modifier
                .padding(8.dp)
                .clickable { selected(name) }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_add_circle),
                    contentDescription = stringResource(id = R.string.main_screen_add_card)
                )
            }
        }
    }
}
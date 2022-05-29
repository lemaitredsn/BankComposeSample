package ru.lemaitre.bankcomposesample.features.offer_detail

import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun OfferDetailScreen(viewModel: OfferDetailViewModel){

}

@Composable
@Preview(showBackground = true)
fun OfferPreviewTest(){
    Box(contentAlignment = Alignment.Center){
        Text(text = "Акция 25% ...")
        Text(text = "Спешите получить ...")
    }
}
package ru.lemaitre.bankcomposesample.features.detail_screen.domain

import androidx.annotation.DrawableRes
import ru.lemaitre.bankcomposesample.R

data class DetailModel(
    val sum: String,
    val number: String,
    @DrawableRes val icon: Int,
    val historyProduct: List<HistoryItem>
){
    companion object{
        fun getDefault() = DetailModel("-1.0","3", R.drawable.union_icon, emptyList())
    }
}
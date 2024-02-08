package model

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

data class HomeUiState(
    val result: MutableState<String> = mutableStateOf(""),
    val firstJson: MutableState<String> = mutableStateOf(""),
    val secondJson: MutableState<String> = mutableStateOf("")
)
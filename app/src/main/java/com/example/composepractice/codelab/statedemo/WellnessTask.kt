package com.example.composepractice.codelab.statedemo

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

//data class WellnessTask(
//    val id: Int,
//    val label: String,
//    // MutableState is used instead of simple Boolean, cause we need to observe this attribute
//    // to detect the checked status
//    var checked: MutableState<Boolean> = mutableStateOf(false)
//)

/**
 * or using delegate properties
 */
data class WellnessTask(
    val id: Int,
    val label: String,
    val initialChecked: Boolean = false
) {
    var checked by mutableStateOf(initialChecked)
}
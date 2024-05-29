package com.example.blackcofferassessment.ui.theme

import android.media.Image
import androidx.compose.ui.graphics.vector.ImageVector

data class InviteCard(
    val name : String,
    val loc : String,
    val role : String,
    val startSym : String,
    val profileScore : Float
)

data class bottomFrames(
    val base : String,
    val id : ImageVector
)
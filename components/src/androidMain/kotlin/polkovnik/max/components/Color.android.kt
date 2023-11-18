package polkovnik.max.components

import android.graphics.Color as AndroidColor

fun Color.toComposeColor(): androidx.compose.ui.graphics.Color =
    androidx.compose.ui.graphics.Color(color = AndroidColor.parseColor(hex))
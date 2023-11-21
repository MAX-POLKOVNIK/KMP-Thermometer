package polkovnik.max.components

import polkovnik.max.mvvm.ViewModelSideEffect
import kotlin.time.Duration

data class Toast(
    val message: String,
    val duration: Duration,
) : ViewModelSideEffect
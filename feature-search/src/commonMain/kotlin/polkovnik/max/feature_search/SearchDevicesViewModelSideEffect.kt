package polkovnik.max.feature_search

import polkovnik.max.components.Toast
import polkovnik.max.mvvm.ViewModelSideEffect

sealed interface SearchDevicesViewModelSideEffect : ViewModelSideEffect {
    data class Toast(
        val toast: polkovnik.max.components.Toast,
    ) : SearchDevicesViewModelSideEffect
}
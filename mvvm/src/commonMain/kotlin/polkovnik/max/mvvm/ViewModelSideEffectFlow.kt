package polkovnik.max.mvvm

import kotlinx.coroutines.flow.Flow

class ViewModelSideEffectFlow<T : ViewModelSideEffect>(origin: Flow<T>) : Flow<T> by origin

fun <T : ViewModelSideEffect> Flow<T>.toViewModelSideEffectFlow(): ViewModelSideEffectFlow<T> =
    ViewModelSideEffectFlow(this)
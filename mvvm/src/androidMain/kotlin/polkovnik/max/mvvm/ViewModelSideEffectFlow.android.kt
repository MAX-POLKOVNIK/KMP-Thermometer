package polkovnik.max.mvvm

import kotlinx.coroutines.flow.Flow

actual class ViewModelSideEffectFlow<T : ViewModelSideEffect> actual constructor(origin: Flow<T>) :
    Flow<T> by origin

actual fun <T : ViewModelSideEffect> Flow<T>.toViewModelSideEffectFlow(): ViewModelSideEffectFlow<T> =
    ViewModelSideEffectFlow(this)
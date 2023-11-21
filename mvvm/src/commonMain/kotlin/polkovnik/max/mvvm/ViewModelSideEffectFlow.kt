package polkovnik.max.mvvm

import kotlinx.coroutines.flow.Flow

expect class ViewModelSideEffectFlow<T : ViewModelSideEffect>(origin: Flow<T>) : Flow<T>

expect fun <T : ViewModelSideEffect> Flow<T>.toViewModelSideEffectFlow(): ViewModelSideEffectFlow<T>
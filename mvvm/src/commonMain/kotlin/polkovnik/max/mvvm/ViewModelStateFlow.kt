package polkovnik.max.mvvm

import kotlinx.coroutines.flow.StateFlow

expect class ViewModelStateFlow<T : ViewModelState> : StateFlow<T>

expect fun <T : ViewModelState> StateFlow<T>.toViewModelStateFlow(): ViewModelStateFlow<T>
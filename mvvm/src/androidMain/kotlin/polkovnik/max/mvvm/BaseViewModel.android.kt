package polkovnik.max.mvvm

import androidx.lifecycle.ViewModel

actual abstract class BaseViewModel<State : ViewModelState, SideEffect : ViewModelSideEffect> : ViewModel() {
    actual abstract val state: ViewModelStateFlow<State>
    actual abstract val sideEffect: ViewModelSideEffectFlow<SideEffect>
}
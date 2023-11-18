package polkovnik.max.mvvm

actual abstract class BaseViewModel<State : ViewModelState, SideEffect : ViewModelSideEffect> {
    actual abstract val state: ViewModelStateFlow<State>
    actual abstract val sideEffect: ViewModelSideEffectFlow<SideEffect>
}
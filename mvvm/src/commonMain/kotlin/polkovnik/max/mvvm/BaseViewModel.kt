package polkovnik.max.mvvm

expect abstract class BaseViewModel<State : ViewModelState, SideEffect : ViewModelSideEffect>() {
    abstract val state: ViewModelStateFlow<State>
    abstract val sideEffect: ViewModelSideEffectFlow<SideEffect>
}
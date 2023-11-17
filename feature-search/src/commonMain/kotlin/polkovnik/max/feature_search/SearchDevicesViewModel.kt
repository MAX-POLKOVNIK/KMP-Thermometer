package polkovnik.max.feature_search

import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import polkovnik.max.components.ButtonState
import polkovnik.max.mvvm.BaseViewModel
import polkovnik.max.mvvm.ViewModelSideEffectFlow
import polkovnik.max.mvvm.ViewModelStateFlow
import polkovnik.max.mvvm.toViewModelSideEffectFlow
import polkovnik.max.mvvm.toViewModelStateFlow

class SearchDevicesViewModel : BaseViewModel<SearchDeviceViewModelState, SearchDevicesViewModelSideEffect>() {
    private val _state: MutableStateFlow<SearchDeviceViewModelState> =
        MutableStateFlow(
            SearchDeviceViewModelState.Preview
                .copy(
                    searchButton = SearchDeviceViewModelState.Preview.searchButton
                        .copy(
                            onClick = ::onSearchButtonClicked
                        )
                )
        )

    private val _sideEffect: MutableSharedFlow<SearchDevicesViewModelSideEffect> =
        MutableSharedFlow(
            replay = 0,
            extraBufferCapacity = 1,
            onBufferOverflow = BufferOverflow.DROP_OLDEST
        )

    override val state: ViewModelStateFlow<SearchDeviceViewModelState> =
        _state.toViewModelStateFlow()

    override val sideEffect: ViewModelSideEffectFlow<SearchDevicesViewModelSideEffect> =
        _sideEffect.toViewModelSideEffectFlow()

    private fun onSearchButtonClicked() {
        _state.value =
            if (state.value.isSearchingIndicatorVisible) {
                state.value.copy(
                    isSearchingIndicatorVisible = false,
                    searchButton = ButtonState
                        .Blue("STOP SCANNING", ::onSearchButtonClicked)
                )
            } else {
                state.value.copy(
                    isSearchingIndicatorVisible = true,
                    searchButton = ButtonState
                        .Blue("SEARCH DEVICES", ::onSearchButtonClicked)
                )
            }
    }
}
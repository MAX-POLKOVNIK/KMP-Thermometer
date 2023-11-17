package polkovnik.max.feature_search

import polkovnik.max.components.ButtonState
import polkovnik.max.components.Color
import polkovnik.max.mvvm.ViewModelState

data class SearchDeviceViewModelState(
    val toolbarTitle: String,
    val thermometersTitle: String,
    val isSearchingIndicatorVisible: Boolean,
    val deviceList: List<SearchDevicesListItem>,
    val searchButton: ButtonState,
) : ViewModelState {
    companion object {
        val Preview = SearchDeviceViewModelState(
            toolbarTitle = "Devices",
            thermometersTitle = "Thermometers",
            isSearchingIndicatorVisible = true,
            searchButton = ButtonState.BlueOutline(
                text = "STOP SEARCHING",
                onClick = {},
            ),
            deviceList = listOf(
                SearchDevicesListItem(
                    isIconOutlined = true,
                    deviceName = "LTA Thermometer (958920)",
                    deviceDescription = "EMU. USB. 958920",
                    isDeviceBatteryVisible = true,
                    deviceBattery = "Battery OK",
                    isDisconnectButtonVisible = true,
                    disconnectButtonState = ButtonState.BlueTextOnly(
                        text = "DISC.",
                        onClick = {},
                    ),
                    onDisconnectClick = {},
                    onClick = {},
                    textColor = Color.Primary,
                ),
                SearchDevicesListItem(
                    isIconOutlined = false,
                    deviceName = "LTA Thermometer (324234)",
                    deviceDescription = "EMU. USB. 324234",
                    isDeviceBatteryVisible = false,
                    deviceBattery = "",
                    isDisconnectButtonVisible = false,
                    disconnectButtonState = ButtonState.BlueTextOnly(
                        text = "",
                        onClick = {},
                    ),
                    onDisconnectClick = {},
                    onClick = {},
                    textColor = Color.Black,
                ),
                SearchDevicesListItem(
                    isIconOutlined = false,
                    deviceName = "LTA Thermometer (123566)",
                    deviceDescription = "EMU. Bluetooth. 123566",
                    isDeviceBatteryVisible = false,
                    deviceBattery = "",
                    isDisconnectButtonVisible = false,
                    disconnectButtonState = ButtonState.BlueTextOnly(
                        text = "",
                        onClick = {},
                    ),
                    onDisconnectClick = {},
                    onClick = {},
                    textColor = Color.Black,
                ),
                SearchDevicesListItem(
                    isIconOutlined = false,
                    deviceName = "LTA Thermometer (956930)",
                    deviceDescription = "EMU. USB one channel 956930",
                    isDeviceBatteryVisible = false,
                    deviceBattery = "",
                    isDisconnectButtonVisible = false,
                    disconnectButtonState = ButtonState.BlueTextOnly(
                        text = "",
                        onClick = {},
                    ),
                    onDisconnectClick = {},
                    onClick = {},
                    textColor = Color.Black,
                ),
            )
        )
    }
}

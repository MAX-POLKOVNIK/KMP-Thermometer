package polkovnik.max.feature_search

import polkovnik.max.components.ButtonState
import polkovnik.max.components.Color
import polkovnik.max.mvvm.ListItem

data class SearchDevicesListItem(
    val iconUrl: String = "https://img-cdn.medkomtek.com/pBr8GjO94XbLsamqRaLbTBnvRkQ=/730x411/smart/filters:quality(100):strip_icc():format(webp)/article/uk4bnV3C44ZuczvnxAj_B/original/068185600_1634552010-Termometer-Rektal.jpg",
    val isIconOutlined: Boolean,
    val deviceName: String,
    val deviceDescription: String,
    val deviceBattery: String,
    val isDeviceBatteryVisible: Boolean,
    val textColor: Color,
    val disconnectButtonState: ButtonState,
    val isDisconnectButtonVisible: Boolean,
    val onDisconnectClick: () -> Unit,
    val onClick: () -> Unit,
) : ListItem<String> {

    override val itemId: String = deviceDescription

    companion object {
        val Preview = SearchDevicesListItem(
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
        )
    }
}
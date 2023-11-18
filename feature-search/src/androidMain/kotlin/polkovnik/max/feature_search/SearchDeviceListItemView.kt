package polkovnik.max.feature_search

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import polkovnik.max.components.ButtonView
import polkovnik.max.components.Color
import polkovnik.max.components.toComposeColor

@Composable
fun SearchDeviceListItemView(
    item: SearchDevicesListItem
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(start = 16.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_device_thermostat),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            colorFilter = ColorFilter.tint(item.textColor.toComposeColor()),
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape)
                .border(
                    1.dp,
                    if (item.isIconOutlined) item.textColor.toComposeColor()
                    else Color.Transparent.toComposeColor(),
                    CircleShape
                )
        )

        Column(
            modifier = Modifier
                .padding(start = 16.dp)
        ) {
            Text(
                text = item.deviceName,
                color = item.textColor.toComposeColor(),
            )
            Text(
                text = item.deviceDescription,
                color = item.textColor.toComposeColor(),
            )
            if (item.isDeviceBatteryVisible) {
                Text(
                    text = item.deviceBattery,
                    color = item.textColor.toComposeColor(),
                )
            }
        }

        Spacer(
            modifier = Modifier.weight(1.0f)
        )

        if (item.isDisconnectButtonVisible) {
            ButtonView(
                state = item.disconnectButtonState,
                modifier = Modifier
                    .padding(0.dp)
            )
        }
    }
}

@Preview
@Composable
fun SearchDeviceListItemViewPreview() {
    SearchDeviceListItemView(item = SearchDevicesListItem.Preview)
}

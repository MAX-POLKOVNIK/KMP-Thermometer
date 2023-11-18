package polkovnik.max.feature_search

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import polkovnik.max.components.ButtonView
import polkovnik.max.components.Color
import polkovnik.max.components.R
import polkovnik.max.components.toComposeColor

@Composable
fun SearchDevicesScreenView() {
    val viewModel: SearchDevicesViewModel = SearchDevicesViewModel()
    val state by viewModel.state.collectAsState()

    SearchDevicesScreenStateView(state = state)
}

@Composable
fun SearchDevicesScreenStateView(
    state: SearchDeviceViewModelState,
) {
    Column(
        modifier = Modifier
            .background(Color.White.toComposeColor())
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Primary.toComposeColor()),
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_arrow_back),
                contentDescription = null,
                colorFilter = ColorFilter.tint(Color.White.toComposeColor()),
                modifier = Modifier
                    .padding(16.dp)
                    .size(24.dp)
            )
            Text(
                text = state.toolbarTitle,
                color = Color.White.toComposeColor(),
                fontSize = 18.sp,
                modifier = Modifier
                    .padding(16.dp)
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = state.toolbarTitle,
                fontSize = 18.sp,
                modifier = Modifier
                    .padding(16.dp)
            )
            if (state.isSearchingIndicatorVisible) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .size(48.dp)
                        .padding(16.dp),
                    color = Color.Primary.toComposeColor(),
                    trackColor = Color.White.toComposeColor(),
                )
            }
        }

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            items(state.deviceList) {
                SearchDeviceListItemView(it)
            }
        }

        Spacer(
            modifier = Modifier.weight(1f)
        )

        ButtonView(
            state = state.searchButton,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )
    }
}

@Preview(widthDp = 480, heightDp = 850)
@Composable
fun DefaultPreview() {
    SearchDevicesScreenStateView(state = SearchDeviceViewModelState.Preview)
}


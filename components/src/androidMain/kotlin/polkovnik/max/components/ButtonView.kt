package polkovnik.max.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ButtonView(state: ButtonState, modifier: Modifier = Modifier) {
    Button(
        onClick = { state.onClick() },
        shape = RoundedCornerShape(state.cornerRadius.dp),
        border = BorderStroke(
            width = 1.dp,
            color = state.outlineColor.toComposeColor()
                .takeIf { state.isOutlineVisible }
                ?: Color.Transparent
        ),
        colors = ButtonDefaults.buttonColors(
            containerColor = state.backgroundColor.toComposeColor(),
            disabledContainerColor = state.backgroundColor.toComposeColor(),
        ),
        enabled = state.isEnabled,
        modifier = modifier,
    ) {
        Text(
            text = state.text,
            color = state.textColor.toComposeColor()
        )
    }
}

@Preview
@Composable
fun ButtonViewPreview() {
    Column {
        ButtonView(ButtonState.Blue("Press me!") {})
        ButtonView(ButtonState.BlueDisable("Press me!"))
        ButtonView(ButtonState.BlueOutline("Press me!") {})
        ButtonView(ButtonState.BlueOutlineDisabled("Press me!"))
        ButtonView(ButtonState.BlueTextOnly("Press me!") {})
        ButtonView(ButtonState.BlueTextOnlyDisabled("Press me!"))
    }
}
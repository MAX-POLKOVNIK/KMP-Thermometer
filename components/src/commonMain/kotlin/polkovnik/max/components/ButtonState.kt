package polkovnik.max.components

data class ButtonState(
    val backgroundColor: Color,
    val outlineColor: Color,
    val isOutlineVisible: Boolean,
    val text: String,
    val textColor: Color,
    val isEnabled: Boolean,
    val cornerRadius: Int,
    val onClick: () -> Unit,
) {
    companion object {
        fun Blue(text: String, onClick: () -> Unit): ButtonState =
            ButtonState(
                backgroundColor = Color.Primary,
                isOutlineVisible = false,
                outlineColor = Color.Transparent,
                text = text,
                textColor = Color.White,
                isEnabled = true,
                cornerRadius = 4,
                onClick = onClick,
            )

        fun BlueDisable(text: String): ButtonState =
            ButtonState(
                backgroundColor = Color.Gray75,
                isOutlineVisible = false,
                outlineColor = Color.Transparent,
                text = text,
                textColor = Color.White,
                isEnabled = false,
                cornerRadius = 4,
                onClick = {},
            )

        fun BlueOutline(text: String, onClick: () -> Unit): ButtonState =
            ButtonState(
                backgroundColor = Color.Transparent,
                isOutlineVisible = true,
                outlineColor = Color.Primary,
                text = text,
                textColor = Color.Primary,
                isEnabled = true,
                cornerRadius = 4,
                onClick = onClick,
            )

        fun BlueOutlineDisabled(text: String): ButtonState =
            ButtonState(
                backgroundColor = Color.Transparent,
                isOutlineVisible = true,
                outlineColor = Color.Gray75,
                text = text,
                textColor = Color.Gray75,
                isEnabled = false,
                cornerRadius = 4,
                onClick = {},
            )

        fun BlueTextOnly(text: String, onClick: () -> Unit): ButtonState =
            ButtonState(
                backgroundColor = Color.Transparent,
                isOutlineVisible = false,
                outlineColor = Color.Transparent,
                text = text,
                textColor = Color.Primary,
                isEnabled = true,
                cornerRadius = 0,
                onClick = onClick
            )

        fun BlueTextOnlyDisabled(text: String): ButtonState =
            ButtonState(
                backgroundColor = Color.Transparent,
                isOutlineVisible = false,
                outlineColor = Color.Transparent,
                text = text,
                textColor = Color.Gray75,
                isEnabled = false,
                cornerRadius = 0,
                onClick = {}
            )
    }
}
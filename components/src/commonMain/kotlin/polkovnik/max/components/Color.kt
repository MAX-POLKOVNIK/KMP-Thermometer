package polkovnik.max.components

data class Color(val hex: String) {
    companion object {
        val TwilightBlue = Color("#07468c")
        val Gray75 = Color("#757575")
        val Transparent = Color("#00000000")
        val White = Color("#FFFFFF")

        val Primary = TwilightBlue
    }
}
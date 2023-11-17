package polkovnik.max.components

import platform.UIKit.UIColor

fun Color.toUIColor(): UIColor {
    val colorString =
        if (hex.startsWith("#")) hex.removePrefix("#")
        else hex

    return when (colorString.length) {
        8 -> {
            colorString.chunked(2)
                .let { chunked ->
                    UIColor(
                        red = chunked[1].toInt(16).toDouble() / 255,
                        green = chunked[2].toInt(16).toDouble() / 255,
                        blue = chunked[3].toInt(16).toDouble() / 255,
                        alpha = chunked[0].toInt(16).toDouble() / 255,
                    )
                }
        }
        6 -> {
            colorString.chunked(2)
                .let { chunked ->
                    UIColor(
                        red = chunked[0].toInt(16).toDouble() / 255,
                        green = chunked[1].toInt(16).toDouble() / 255,
                        blue = chunked[2].toInt(16).toDouble() / 255,
                        alpha = 1.0,
                    )
                }
        }
        else -> error("Can't parse color $hex")
    }
}
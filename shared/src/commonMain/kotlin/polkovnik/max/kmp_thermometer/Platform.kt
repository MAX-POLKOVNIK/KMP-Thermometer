package polkovnik.max.kmp_thermometer

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
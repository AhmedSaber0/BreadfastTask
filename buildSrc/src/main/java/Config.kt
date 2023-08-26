import org.gradle.api.JavaVersion

object Config {
    const val minSdk = 24
    const val compileSdk = 33
    const val targetSdk = 33

    val javaVersion = JavaVersion.VERSION_17
}

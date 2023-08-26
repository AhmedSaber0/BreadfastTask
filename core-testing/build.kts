import dependencies.Dependencies

apply plugin : 'org.jetbrains.kotlin.android'

dependencies {

    implementation(project(":core"))

    implementation(Dependencies.Kotlin.stdlib)

    implementation(Dependencies.DI.daggerHilt)
    kapt(Dependencies.DI.daggerHiltCompiler)
    implementation(Dependencies.Rx.java)
    implementation(Dependencies.Rx.kotlin)
    implementation(Dependencies.Rx.android)
}

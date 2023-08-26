import dependencies.Dependencies

dependencies {
    implementation(Dependencies.Kotlin.stdlib)
    implementation(Dependencies.Jetpack.lifecycleRuntime)
    implementation(Dependencies.AndroidX.appcompat)
    implementation(Dependencies.AndroidX.activity)
    implementation(Dependencies.AndroidX.fragment)
    implementation(Dependencies.Jetpack.navigationUi)
    implementation(Dependencies.Jetpack.navigationFragment)
    implementation(Dependencies.AndroidX.recyclerview)

    implementation(Dependencies.Image.glide)

    implementation(Dependencies.Networking.loggingInterceptor)
    implementation(Dependencies.Networking.retrofit)
    implementation(Dependencies.Networking.retrofitRx)
    implementation(Dependencies.Networking.moshiConverter)

    implementation(Dependencies.DI.daggerHilt)
    kapt(Dependencies.DI.daggerHiltCompiler)

    implementation(Dependencies.Rx.java)
    implementation(Dependencies.Rx.kotlin)
    implementation(Dependencies.Rx.android)

    testImplementation(Dependencies.Test.junit)

    androidTestImplementation(Dependencies.AndroidTest.runner)
}

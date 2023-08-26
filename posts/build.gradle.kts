import dependencies.Dependencies

plugins {
    id("com.android.library")
    id("kotlin-android")
    id("dagger.hilt.android.plugin")
    id("com.google.devtools.ksp")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    namespace = "com.example.posts"
    compileSdk = Config.compileSdk

    defaultConfig {
        minSdk = Config.minSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    compileOptions {
        sourceCompatibility = Config.javaVersion
        targetCompatibility = Config.javaVersion
    }
    kotlinOptions {
        jvmTarget = Config.javaVersion.toString()
    }

    buildFeatures {
        viewBinding = true
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                file("proguard-rules.pro")
            )
        }
    }
}
dependencies {

    implementation(project(":core"))

    implementation(Dependencies.Kotlin.stdlib)
    implementation(Dependencies.AndroidX.ktx)
    implementation(Dependencies.AndroidX.appcompat)
    implementation(Dependencies.AndroidX.recyclerview)
    implementation(Dependencies.Google.material)
    implementation(Dependencies.Image.glide)

    implementation(Dependencies.Jetpack.lifecycleRuntime)
    implementation(Dependencies.Jetpack.navigationUi)
    implementation(Dependencies.Jetpack.navigationFragment)

    implementation(Dependencies.DI.daggerHilt)
    kapt(Dependencies.DI.daggerHiltCompiler)

    implementation(Dependencies.Networking.loggingInterceptor)
    implementation(Dependencies.Networking.retrofit)
    implementation(Dependencies.Networking.retrofitCoroutine)
    implementation(Dependencies.Networking.moshiConverter)

    implementation(Dependencies.Coroutines.coroutineCore)
    implementation(Dependencies.Coroutines.coroutineAndroid)

    testImplementation(project(":posts:test"))
    testImplementation(project(":core-testing"))
    testImplementation(Dependencies.Test.junit)
    testImplementation(Dependencies.Test.core)
    testImplementation(Dependencies.Test.arch)
    testImplementation(Dependencies.Test.mockitoKotlin)
    testImplementation(Dependencies.Test.mockitoInline)

}

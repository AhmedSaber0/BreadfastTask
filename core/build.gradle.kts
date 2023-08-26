import dependencies.Dependencies

plugins {
    id("com.android.library")
    id("kotlin-android")
    id("dagger.hilt.android.plugin")
    id("com.google.devtools.ksp")
    id("kotlin-kapt")
    id("kotlin-parcelize")
}

android {
    namespace = "com.example.core"
    compileSdk = Config.compileSdk

    defaultConfig {
        minSdk = Config.minSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
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
        buildConfig = true
    }
}

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
    implementation(Dependencies.Networking.retrofitCoroutine)
    implementation(Dependencies.Networking.moshiConverter)

    implementation(Dependencies.DI.daggerHilt)
    kapt(Dependencies.DI.daggerHiltCompiler)

    implementation(Dependencies.Coroutines.coroutineCore)
    implementation(Dependencies.Coroutines.coroutineAndroid)

    testImplementation(Dependencies.Test.junit)

    androidTestImplementation(Dependencies.AndroidTest.runner)
}

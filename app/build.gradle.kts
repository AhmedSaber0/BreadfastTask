import dependencies.Dependencies

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("dagger.hilt.android.plugin")
    id("kotlin-android")
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.example.breadfasttask"
    compileSdk = Config.compileSdk

    defaultConfig {
        applicationId = "com.example.breadfasttask"
        minSdk = Config.minSdk
        targetSdk = Config.targetSdk
        versionCode = 1
        versionName = "1.0"

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
    }
}

dependencies {
    implementation(project(":core"))

    implementation(Dependencies.Kotlin.stdlib)
    implementation(Dependencies.AndroidX.ktx)
    implementation(Dependencies.AndroidX.appcompat)
    implementation(Dependencies.Google.material)

    implementation(Dependencies.DI.daggerHilt)
    ksp(Dependencies.DI.daggerHiltCompiler)

    implementation(Dependencies.Networking.loggingInterceptor)
    implementation(Dependencies.Networking.retrofit)
    implementation(Dependencies.Networking.retrofitRx)
    implementation(Dependencies.Networking.moshiConverter)
}
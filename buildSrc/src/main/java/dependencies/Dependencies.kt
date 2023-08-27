package dependencies

import Versions

object Dependencies {

    object Kotlin {
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.Kotlin.kotlin}"
    }

    object AndroidX {
        const val appcompat = "androidx.appcompat:appcompat:${Versions.AndroidX.appcompat}"
        const val constraintlayout =
            "androidx.constraintlayout:constraintlayout:${Versions.AndroidX.constraintlayout}"
        const val activity = "androidx.activity:activity:${Versions.AndroidX.activity}"
        const val fragment = "androidx.fragment:fragment-ktx:${Versions.AndroidX.fragment}"
        const val ktx = "androidx.core:core-ktx:${Versions.AndroidX.ktx}"
        const val recyclerview =
            "androidx.recyclerview:recyclerview:${Versions.AndroidX.recyclerview}"
    }

    object Jetpack {
        const val lifecycleRuntime =
            "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.Jetpack.lifecycle}"

        const val navigationUi =
            "androidx.navigation:navigation-fragment-ktx:${Versions.Jetpack.navigation}"
        const val navigationFragment =
            "androidx.navigation:navigation-ui-ktx:${Versions.Jetpack.navigation}"
        const val navigationSafeArgsPlugin =
            "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.Jetpack.navigation}"
    }

    object Google {
        const val material = "com.google.android.material:material:${Versions.Google.material}"
    }

    object Networking {
        const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.Libraries.retrofit}"
        const val retrofitCoroutine =
            "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:${Versions.Libraries.retrofitCoroutine}"
        const val moshiConverter =
            "com.squareup.retrofit2:converter-moshi:${Versions.Libraries.retrofit}"
        const val moshi =
            "com.squareup.moshi:moshi:${Versions.Libraries.moshi}"
        const val moshiAdapters =
            "com.squareup.moshi:moshi-adapters:${Versions.Libraries.moshi}"
        const val moshiCodegen =
            "com.squareup.moshi:moshi-kotlin-codegen:${Versions.Libraries.moshi}"
        const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.Libraries.okhttp}"
        const val loggingInterceptor =
            "com.squareup.okhttp3:logging-interceptor:${Versions.Libraries.okhttp}"
    }

    object Coroutines {
        const val coroutineCore =
            "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.Libraries.coroutineCore}"
        const val coroutineAndroid =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.Libraries.coroutineAndroid}"
    }

    object DI {
        const val daggerHilt = "com.google.dagger:hilt-android:${Versions.Libraries.daggerHilt}"
        const val daggerHiltCompiler =
            "com.google.dagger:hilt-compiler:${Versions.Libraries.daggerHilt}"
    }

    object Image {
        const val glide = "com.github.bumptech.glide:glide:${Versions.Libraries.glide}"
        const val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.Libraries.glide}"
    }

    object Test {
        const val junit = "junit:junit:${Versions.Test.junit}"
        const val core = "androidx.test:core:${Versions.Test.core}"
        const val mockkAndroid = "io.mockk:mockk-android:${Versions.Test.mockk}"
        const val mockk = "io.mockk:mockk:${Versions.Test.mockk}"
        const val coroutinesTest =
            "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.Test.coroutinesTest}"
        const val coreTesting = "androidx.arch.core:core-testing:${Versions.Test.coreTesting}"
    }
}

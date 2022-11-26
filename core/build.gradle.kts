import com.bigbackboom.tryandroidstuff.build.AppVersion
import com.bigbackboom.tryandroidstuff.build.Deps

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("org.jetbrains.kotlin.plugin.serialization")
}

android {

    namespace = "com.bigbackboom.tryandroidstuff.core"
    compileSdk = AppVersion.compileSdkVersion

    defaultConfig {
        minSdk = AppVersion.minSdkVersion
        targetSdk = AppVersion.targetSdkVersion
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildFeatures.dataBinding = true
}

dependencies {
    // AndroidX
    implementation(Deps.AndroidX.design)
    implementation(Deps.AndroidX.appCompat)

    // Kotlin
    implementation(Deps.Kotlin.serialization)

    // Dagger(Hilt)
    implementation(Deps.Dagger.hilt)
    kapt(Deps.Dagger.hiltCompiler)

    // Android Utility
    implementation(Deps.Glide.core)
    implementation(Deps.Glide.integration)
    kapt(Deps.Glide.compiler)

    // Retrofit
    implementation(Deps.Retrofit2.retrofit)
    implementation(Deps.Retrofit2.retrofitSerializationConverter)

    // Okhttp
    implementation(Deps.Okhttp.okhttp)
    implementation(Deps.Okhttp.logger)
}

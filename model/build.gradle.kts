import com.bigbackboom.tryandroidstuff.build.AppVersion
import com.bigbackboom.tryandroidstuff.build.Deps

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.plugin.serialization")
}

android {

    namespace = "com.bigbackboom.tryandroidstuff.model"
    compileSdk = AppVersion.compileSdkVersion

    defaultConfig {
        minSdk = AppVersion.minSdkVersion
        targetSdk = AppVersion.targetSdkVersion
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildFeatures.dataBinding = true
}

dependencies {
    // Kotlin
    implementation(Deps.Kotlin.serialization)

    // Retrofit
    implementation(Deps.Retrofit2.retrofit)
}

import com.bigbackboom.tryandroidstuff.build.AppVersion
import com.bigbackboom.tryandroidstuff.build.Deps

plugins {
    id("com.android.library")
    id("kotlin-kapt")
    id("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android")
    id("androidx.navigation.safeargs")
}

android {
    namespace = "com.bigbackboom.tryandroidstuff.feature.usersearch"

    compileSdk = AppVersion.compileSdkVersion

    defaultConfig {
        minSdk = AppVersion.minSdkVersion
        targetSdk = AppVersion.targetSdkVersion
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        dataBinding = true
    }
}

dependencies {
    // modules
    implementation(project(":core"))
    implementation(project(":data"))
    implementation(project(":model"))

    // AndroidX
    implementation(Deps.AndroidX.Ktx.core)
    implementation(Deps.AndroidX.appCompat)
    implementation(Deps.AndroidX.design)
    implementation(Deps.AndroidX.constraintLayout)
    implementation(Deps.AndroidX.liveData)
    implementation(Deps.AndroidX.Ktx.navigationFragment)
    implementation(Deps.AndroidX.Ktx.navigationUI)
    implementation(Deps.AndroidX.Ktx.liveDataKtx)
    implementation(Deps.AndroidX.Ktx.liveDataKtx)
    implementation(Deps.AndroidX.browser)

    // Dagger(Hilt)
    implementation(Deps.Dagger.hilt)
    kapt(Deps.Dagger.hiltCompiler)

    // Log
    implementation(Deps.Timber.timber)
}

import com.bigbackboom.tryandroidstuff.build.AppVersion
import com.bigbackboom.tryandroidstuff.build.Deps

plugins {
    id("com.android.library")
    id("kotlin-kapt")
    id("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android")
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

    // AndroidX
    implementation(Deps.AndroidX.Ktx.core)
    implementation(Deps.AndroidX.appCompat)
    implementation(Deps.AndroidX.design)
    implementation(Deps.AndroidX.constraintLayout)
    implementation(Deps.AndroidX.Ktx.navigationFragment)
    implementation(Deps.AndroidX.Ktx.navigationUI)

    // Dagger(Hilt)
    implementation(Deps.Dagger.hilt)
    kapt(Deps.Dagger.hiltCompiler)
}

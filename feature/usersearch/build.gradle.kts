import com.bigbackboom.tryandroidstuff.build.AppVersion

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
    implementation(com.bigbackboom.tryandroidstuff.build.Deps.AndroidX.Ktx.core)
    implementation(com.bigbackboom.tryandroidstuff.build.Deps.AndroidX.appCompat)
    implementation(com.bigbackboom.tryandroidstuff.build.Deps.AndroidX.design)
    implementation(com.bigbackboom.tryandroidstuff.build.Deps.AndroidX.constraintLayout)
    implementation(com.bigbackboom.tryandroidstuff.build.Deps.AndroidX.Ktx.navigationFragment)
    implementation(com.bigbackboom.tryandroidstuff.build.Deps.AndroidX.Ktx.navigationUI)

    // Dagger(Hilt)
    implementation(com.bigbackboom.tryandroidstuff.build.Deps.Dagger.hilt)
    kapt(com.bigbackboom.tryandroidstuff.build.Deps.Dagger.hiltCompiler)
}

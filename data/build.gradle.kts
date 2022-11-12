import com.bigbackboom.tryandroidstuff.build.AppVersion

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {

    namespace = "com.bigbackboom.tryandroidstuff.data"
    compileSdk = AppVersion.compileSdkVersion

    defaultConfig {
        minSdk = AppVersion.minSdkVersion
        targetSdk = AppVersion.targetSdkVersion
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildFeatures.dataBinding = true
}

dependencies {
}

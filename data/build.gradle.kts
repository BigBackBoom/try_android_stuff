import com.bigbackboom.tryandroidstuff.build.AppVersion
import com.bigbackboom.tryandroidstuff.build.Deps

plugins {
    id("com.android.library")
    id("kotlin-kapt")
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
    implementation(project(":core"))
    implementation(project(":model"))

    // Moshi
    implementation(Deps.Moshi.moshi)

    // Dagger(Hilt)
    implementation(Deps.Dagger.hilt)
    kapt(Deps.Dagger.hiltCompiler)

    // Retrofit
    implementation(Deps.Retrofit2.retrofit)
    implementation(Deps.Retrofit2.retrofitConverter)
}

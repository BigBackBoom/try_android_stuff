import com.bigbackboom.tryandroidstuff.build.AppVersion

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

    // Dagger(Hilt)
    implementation(com.bigbackboom.tryandroidstuff.build.Deps.Dagger.hilt)
    kapt(com.bigbackboom.tryandroidstuff.build.Deps.Dagger.hiltCompiler)

    // Retrofit
    implementation(com.bigbackboom.tryandroidstuff.build.Deps.Retrofit2.retrofit)
    implementation(com.bigbackboom.tryandroidstuff.build.Deps.Retrofit2.retrofitConverter)
}

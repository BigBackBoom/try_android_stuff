import com.bigbackboom.tryandroidstuff.build.AppVersion

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.bigbackboom.tryandroidstuff.feature.usersearch"

    compileSdk = AppVersion.compileSdkVersion

    defaultConfig {
        minSdk = AppVersion.minSdkVersion
        targetSdk = AppVersion.targetSdkVersion
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

dependencies {

//    implementation("com.android.support:appcompat-v7:28.0.0")
//    testImplementation("junit:junit:4.13.2")
//    androidTestImplementation("com.android.support.test:runner:1.0.2")
//    androidTestImplementation("com.android.support.test.espresso:espresso-core:3.0.2")
}

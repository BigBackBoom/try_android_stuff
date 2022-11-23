import com.bigbackboom.tryandroidstuff.build.AppVersion
import com.bigbackboom.tryandroidstuff.build.Deps
import com.bigbackboom.tryandroidstuff.build.Package

plugins {
    id("com.android.application")
    id("kotlin-kapt")
    id("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.bigbackboom.tryandroidstuff"
    compileSdk = AppVersion.compileSdkVersion

    defaultConfig {
        applicationId = Package.name
        minSdk = AppVersion.minSdkVersion
        targetSdk = AppVersion.targetSdkVersion
        versionCode = AppVersion.versionCode
        versionName = AppVersion.versionName
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile(
                    "proguard-android-optimize.txt"
                ),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        dataBinding = true
    }
}

dependencies {
    // modules
    implementation(project(":core"))
    implementation(project(":feature:usersearch"))

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

    // Test
    testImplementation(Deps.Test.jUnit)
    androidTestImplementation(Deps.AndroidX.Test.jUnit)
    androidTestImplementation(Deps.AndroidX.Test.espresso)
}

kapt {
    correctErrorTypes = true
}

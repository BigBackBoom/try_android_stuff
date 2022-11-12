import com.bigbackboom.tryandroidstuff.build.Package
import com.bigbackboom.tryandroidstuff.build.AppVersion
import com.bigbackboom.tryandroidstuff.build.Deps

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(Deps.AndroidX.Ktx.core)
    implementation(Deps.AndroidX.appCompat)
    implementation(Deps.AndroidX.design)
    implementation(Deps.AndroidX.constraintLayout)
    implementation(Deps.AndroidX.Ktx.navigationFragment)
    implementation(Deps.AndroidX.Ktx.navigationUI)
    testImplementation(Deps.Test.jUnit)
    androidTestImplementation(Deps.AndroidX.Test.jUnit)
    androidTestImplementation(Deps.AndroidX.Test.espresso)
}

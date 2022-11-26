package com.bigbackboom.tryandroidstuff.build

object Deps {

    object AndroidX {
        private const val lifecycleVersion = "2.5.1"

        const val design = "com.google.android.material:material:1.7.0"
        const val appCompat = "androidx.appcompat:appcompat:1.5.1"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.1.4"
        const val liveData = "androidx.lifecycle:lifecycle-livedata:$lifecycleVersion"
        const val browser = "androidx.browser:browser:1.4.0"

        object Ktx {
            const val core = "androidx.core:core-ktx:1.7.0"
            const val liveDataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:$lifecycleVersion"
            const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:2.5.3"
            const val navigationUI = "androidx.navigation:navigation-ui-ktx:2.5.3"
        }

        object Test {
            const val jUnit = "androidx.test.ext:junit:1.1.4"
            const val espresso = "androidx.test.espresso:espresso-core:3.5.0"
        }
    }

    object Kotlin {
        const val serialization = "org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.1"
    }

    object Dagger {
        const val hilt = "com.google.dagger:hilt-android:2.44"
        const val hiltCompiler = "com.google.dagger:hilt-compiler:2.44"
    }

    object Retrofit2 {
        const val retrofit = "com.squareup.retrofit2:retrofit:2.9.0"
        const val retrofitSerializationConverter =
            "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:0.8.0"
    }

    object Glide {
        private const val glideVersion = "4.14.2"

        const val core = "com.github.bumptech.glide:glide:$glideVersion"
        const val integration = "com.github.bumptech.glide:okhttp3-integration:$glideVersion"
        const val compiler = "com.github.bumptech.glide:compiler:$glideVersion"
    }

    object Okhttp {
        const val okhttp = "com.squareup.okhttp3:okhttp:4.10.0"
        const val logger = "com.squareup.okhttp3:logging-interceptor:4.10.0"
    }

    object Timber {
        const val timber = "com.jakewharton.timber:timber:5.0.1"
    }

    object Test {
        const val jUnit = "junit:junit:4.13.2"
    }
}

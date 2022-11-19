package com.bigbackboom.tryandroidstuff.build

object Deps {

    object AndroidX {
        const val design = "com.google.android.material:material:1.7.0"
        const val appCompat = "androidx.appcompat:appcompat:1.5.1"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.1.4"

        object Ktx {
            const val core = "androidx.core:core-ktx:1.7.0"
            const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:2.5.3"
            const val navigationUI = "androidx.navigation:navigation-ui-ktx:2.5.3"
        }

        object Test {
            const val jUnit = "androidx.test.ext:junit:1.1.4"
            const val espresso = "androidx.test.espresso:espresso-core:3.5.0"
        }
    }

    object Dagger {
        const val hilt = "com.google.dagger:hilt-android:2.44"
        const val hiltCompiler = "com.google.dagger:hilt-compiler:2.44"
    }

    object Retrofit2 {
        const val retrofit = "com.squareup.retrofit2:retrofit:2.9.0"
        const val retrofitConverter = "com.squareup.retrofit2:converter-moshi:2.9.0"
    }

    object Moshi {
        const val moshi = "com.squareup.moshi:moshi-kotlin:1.14.0"
    }

    object Okhttp {
        const val okhttp = "com.squareup.okhttp3:okhttp:4.10.0"
        const val logger = "com.squareup.okhttp3:logging-interceptor:4.10.0"
    }

    object Test {
        const val jUnit = "junit:junit:4.13.2"
    }
}

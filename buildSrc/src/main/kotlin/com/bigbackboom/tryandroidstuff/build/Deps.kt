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

    object Test {
        const val jUnit = "junit:junit:4.13.2"

    }
}

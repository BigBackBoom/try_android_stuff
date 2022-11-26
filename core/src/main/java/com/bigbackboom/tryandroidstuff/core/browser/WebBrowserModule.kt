package com.bigbackboom.tryandroidstuff.core.browser

import android.content.Context
import androidx.browser.customtabs.CustomTabsIntent
import com.bigbackboom.tryandroidstuff.core.R
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ActivityContext


@Module
@InstallIn(ActivityComponent::class)
class WebBrowserModule {

    @Provides
    fun provideCustomTabsIntent(
        @ActivityContext context: Context
    ): CustomTabsIntent {
        return CustomTabsIntent.Builder()
            .setShowTitle(true)
            .setStartAnimations(context, R.anim.anim_slide_enter, R.anim.anim_slide_exit)
            .setExitAnimations(context, R.anim.anim_slide_pop_exit, R.anim.anim_slide_pop_exit)
            .build()
    }
}

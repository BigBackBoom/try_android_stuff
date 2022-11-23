package com.bigbackboom.tryandroidstuff.core.network

import android.content.Context
import com.bigbackboom.tryandroidstuff.core.R
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import java.util.concurrent.TimeUnit
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor

@Module
@InstallIn(SingletonComponent::class)
class ApiClientModule {

    @GithubClient
    @Provides
    fun provideGithubOkHttpClient(
        @ApplicationContext context: Context
    ): OkHttpClient {
        // client
        val okHttpClientBuilder = OkHttpClient.Builder()
        okHttpClientBuilder.addInterceptor {
            //header設定
            val builder: Request.Builder =  it.request().newBuilder().apply {
                addHeader(
                    context.getString(R.string.api_key_accept),
                    context.getString(R.string.api_value_github_content_type)
                )
                addHeader(
                    context.getString(R.string.api_key_authorization),
                    context.getString(
                        R.string.api_value_authorization,
                        context.getString(R.string.github_token)
                    )
                )
            }

            it.proceed(builder.build())
        }

        return okHttpClientBuilder
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()
    }
}

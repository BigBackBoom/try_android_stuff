package com.bigbackboom.tryandroidstuff.core.network

import android.content.Context
import com.bigbackboom.tryandroidstuff.core.R
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @GithubClient
    @Provides
    fun provideGithubRetrofit(
        @ApplicationContext context: Context,
        converter: Converter.Factory,
        @GithubClient client: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(context.getString(R.string.github_host))
            .addConverterFactory(converter)
            .client(client)
            .build()
    }

    @Provides
    fun provideSerializableAdapter(): Converter.Factory {
        val contentType = "application/json".toMediaType()
        val format = Json { ignoreUnknownKeys = true }
        return format.asConverterFactory(contentType)
    }

}

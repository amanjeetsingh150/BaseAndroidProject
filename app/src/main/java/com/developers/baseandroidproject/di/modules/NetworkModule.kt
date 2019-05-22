package com.developers.baseandroidproject.di.modules

import android.content.Context
import com.developers.baseandroidproject.data.remote.StarterApiService
import com.developers.baseandroidproject.utils.BigDecimalJsonAdapter
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.CallAdapter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.File
import java.math.BigDecimal
import javax.inject.Singleton

private const val HTTP_CACHE = "http"
private const val HTTP_DISK_CACHE_SIZE = 50 * 1000L // 50 MB

@Module
object NetworkModule {

    @JvmStatic
    @Provides
    fun provideBaseUrl(): String =
        ""

    @JvmStatic
    @Provides
    @Singleton
    fun provideHttpCache(context: Context): Cache {
        val cacheDir = File(context.cacheDir, HTTP_CACHE)
        return Cache(cacheDir, HTTP_DISK_CACHE_SIZE)
    }

    @JvmStatic
    @Provides
    @Singleton
    fun provideOkHttpClient(
        cache: Cache
    ): OkHttpClient {
        val okHttpBuilder = OkHttpClient
            .Builder()
            .cache(cache)
        return okHttpBuilder
            .build()
    }

    @JvmStatic
    @Provides
    fun providesRxJavaCallAdapterFactory(): RxJava2CallAdapterFactory = RxJava2CallAdapterFactory.create()

    @JvmStatic
    @Provides
    fun provideCallAdapterFactory(): CallAdapter.Factory =
        RxJava2CallAdapterFactory.create()

    @JvmStatic
    @Provides
    fun provideMoshi(): Moshi =
        Moshi.Builder()
            .add(BigDecimal::class.java, BigDecimalJsonAdapter())
            .build()

    @JvmStatic
    @Provides
    @Singleton
    fun provideRetrofit(
        baseUrl: String,
        okHttpClient: OkHttpClient,
        callAdapterFactory: RxJava2CallAdapterFactory,
        moshi: Moshi
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addCallAdapterFactory(callAdapterFactory)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    @JvmStatic
    @Provides
    @Singleton
    fun provideStarterApi(retrofit: Retrofit): StarterApiService =
        retrofit.create(StarterApiService::class.java)
}
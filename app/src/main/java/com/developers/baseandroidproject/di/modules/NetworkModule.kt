package com.developers.baseandroidproject.di.modules

import android.content.Context
import com.developers.baseandroidproject.utils.BigDecimalJsonAdapter
import com.squareup.moshi.Moshi
import dagger.Binds
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

private const val HTTP_CACHE = "http"
private const val HTTP_DISK_CACHE_SIZE = 50 * 1000L // 50 MB

@Module
abstract class NetworkModule {

    @Binds
    abstract fun providesBaseUrl(url: String): String

    @Module
    companion object {
        @JvmStatic
        @Provides
        fun providesHttpCache(context: Context): Cache {
            val cacheDir = File(context.cacheDir, HTTP_CACHE)
            return Cache(cacheDir, HTTP_DISK_CACHE_SIZE)
        }

        @JvmStatic
        @Provides
        fun provideCallAdapterFactory(): CallAdapter.Factory =
            RxJava2CallAdapterFactory.create()

        @JvmStatic
        @Provides
        fun providesOkHttpClient(cache: Cache): OkHttpClient {
            return OkHttpClient
                .Builder()
                .cache(cache).build()
        }

        /**
         * Add more Json Adapters top builder if needed
         */
        @Provides
        @JvmStatic
        fun providesMoshi(): Moshi = Moshi.Builder()
            .add(BigDecimal::class.java, BigDecimalJsonAdapter())
            .build()

        @JvmStatic
        @Provides
        fun providesRetroft(
            url: String,
            callAdapterFactory: RxJava2CallAdapterFactory,
            moshiConverterFactory: MoshiConverterFactory
        ): Retrofit =
            Retrofit.Builder()
                .baseUrl(url)
                .addCallAdapterFactory(callAdapterFactory)
                .addConverterFactory(moshiConverterFactory)
                .build()


    }
}
package com.developers.baseandroidproject.di

import com.developers.baseandroidproject.data.remote.StarterApiService
import com.developers.baseandroidproject.di.modules.AppModule
import com.developers.baseandroidproject.di.modules.LogModule
import com.developers.baseandroidproject.di.modules.NetworkModule
import com.developers.baseandroidproject.executors.AppSchedulers
import dagger.Component
import timber.log.Timber
import javax.inject.Singleton

@Singleton
@Component(
    modules = [LogModule::class,
        AppModule::class,
        NetworkModule::class]
)
interface AppComponent {

    fun timberTree(): Timber.Tree

    fun schedulerProvider(): AppSchedulers

    fun apiService(): StarterApiService
}
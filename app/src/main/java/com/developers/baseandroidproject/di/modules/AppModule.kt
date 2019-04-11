package com.developers.baseandroidproject.di.modules

import android.app.Application
import android.content.Context
import com.developers.baseandroidproject.executors.AppSchedulers
import com.developers.baseandroidproject.executors.RxSchedulers
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val application: Application) {
    @Provides
    @Singleton
    fun provideAppContext(): Context = application

    @Provides
    @Singleton
    fun providesSchedulers(): AppSchedulers = RxSchedulers()
}

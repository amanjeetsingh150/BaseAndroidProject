package com.developers.baseandroidproject.di.modules

import android.app.Application
import android.content.Context
import com.developers.baseandroidproject.executors.RxSchedulers
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class AppModule {

    @Binds
    abstract fun bindContext(application: Application): Context

    @Module
    companion object {
        @JvmStatic
        @Provides
        fun providesExecutors() = RxSchedulers()
    }
}
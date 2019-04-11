package com.developers.baseandroidproject.di.modules

import dagger.Module
import dagger.Provides
import timber.log.Timber
import javax.inject.Singleton

@Module
object LogModule {

    @Provides
    @JvmStatic
    @Singleton
    fun providingLogginTree(): Timber.Tree = object : Timber.Tree() {
        override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
            //NO-OP
        }
    }
}
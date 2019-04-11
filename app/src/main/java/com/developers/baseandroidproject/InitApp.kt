package com.developers.baseandroidproject

import android.app.Activity
import android.app.Application
import android.content.Context
import com.developers.baseandroidproject.di.AppComponent
import com.developers.baseandroidproject.di.DaggerAppComponent
import com.developers.baseandroidproject.di.modules.AppModule

class InitApp : Application() {

    private val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }

    companion object {
        @JvmStatic
        fun appComponent(context: Context) = (context as InitApp).appComponent
    }
}

fun Activity.appComponent() = InitApp.appComponent(this)
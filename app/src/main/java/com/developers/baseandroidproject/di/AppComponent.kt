package com.developers.baseandroidproject.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component

@Component
interface AppComponent {

    /**
     * A custom builder to build DaggerAppComponent binding your application class
     */
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): AppComponent.Builder

        fun build(): AppComponent
    }
}
package com.developers.baseandroidproject.di.components

import com.developers.baseandroidproject.di.AppComponent
import com.developers.baseandroidproject.di.modules.ActivityModule
import com.developers.baseandroidproject.di.scopes.ActivityScope
import com.developers.baseandroidproject.home.HomeActivity
import dagger.BindsInstance
import dagger.Component

@ActivityScope
@Component(modules = [ActivityModule::class],
    dependencies = [AppComponent::class])
interface ActivityComponent {


    fun inject(homeActivity: HomeActivity)

    @Component.Builder
    interface Builder {

        fun build(): ActivityComponent

        @BindsInstance
        fun homeActivity(activity: HomeActivity): Builder

        fun appComponent(appComponent: AppComponent): Builder
    }
}
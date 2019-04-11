package com.developers.baseandroidproject.di.modules

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.developers.baseandroidproject.di.scopes.ActivityScope
import com.developers.baseandroidproject.home.HomeActivity
import com.developers.baseandroidproject.home.HomeViewModel
import com.developers.baseandroidproject.home.HomeViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class ActivityModule {

    @Binds
    abstract fun homeActivity(activity: HomeActivity): AppCompatActivity


    @Module
    companion object {
        @JvmStatic
        @Provides
        fun homeViewModel(
            homeViewModelFactory: HomeViewModelFactory,
            activity: AppCompatActivity
        ): HomeViewModel {
            return ViewModelProviders.of(activity, homeViewModelFactory).get(HomeViewModel::class.java)
        }
    }
}
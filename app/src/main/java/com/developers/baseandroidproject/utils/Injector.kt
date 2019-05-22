package com.developers.baseandroidproject.utils

import com.developers.baseandroidproject.appComponent
import com.developers.baseandroidproject.di.components.DaggerActivityComponent
import com.developers.baseandroidproject.home.HomeActivity

fun inject(activity: HomeActivity) {

    DaggerActivityComponent.builder()
        .appComponent(activity.appComponent())
        .homeActivity(activity)
        .build()
        .inject(activity)
}
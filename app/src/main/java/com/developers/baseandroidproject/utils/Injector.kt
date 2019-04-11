package com.developers.baseandroidproject.utils

import com.developers.baseandroidproject.appComponent
import com.developers.baseandroidproject.di.components.DaggerActivityComponent
import com.developers.baseandroidproject.home.HomeActivity

fun inject(homeActivity: HomeActivity) {

    DaggerActivityComponent.builder()
        .appComponent(homeActivity.appComponent())
        .build()
        .inject(homeActivity)
}
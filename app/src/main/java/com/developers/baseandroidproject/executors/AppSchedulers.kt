package com.developers.baseandroidproject.executors

import io.reactivex.Scheduler

interface AppSchedulers {
    val computation: Scheduler
    val io: Scheduler
    val ui: Scheduler
}
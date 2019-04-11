package com.developers.baseandroidproject.executors

import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import io.reactivex.android.schedulers.AndroidSchedulers

class RxSchedulers : AppSchedulers {

    override val computation: Scheduler
        get() = Schedulers.computation()

    override val io: Scheduler
        get() = Schedulers.io()

    override val ui: Scheduler
        get() = AndroidSchedulers.mainThread()
}
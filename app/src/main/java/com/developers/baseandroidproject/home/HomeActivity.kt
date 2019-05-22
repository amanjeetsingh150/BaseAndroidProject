package com.developers.baseandroidproject.home

import android.os.Bundle
import com.developers.baseandroidproject.R
import com.developers.baseandroidproject.base.BaseActivity
import com.developers.baseandroidproject.utils.inject
import javax.inject.Inject

class HomeActivity : BaseActivity() {

    @Inject
    lateinit var homeViewModel: HomeViewModel

    override fun getLayoutRes() = R.layout.activity_main

    override fun injectSelf() {
        super.injectSelf()
        inject(this)
    }

    /**
     * Any kind of setup needed can be done here
     */
    override fun setup(savedInstanceState: Bundle?) {
        super.setup(savedInstanceState)
    }

}

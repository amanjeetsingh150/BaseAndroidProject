package com.developers.baseandroidproject.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity

/**
 * A base activity for all the Activities in project.
 * All the common things like show and hide progress can be placed here
 */

abstract class BaseActivity : AppCompatActivity() {

    /**
     * Inject itself to dagger graph
     */
    open fun injectSelf() {}

    /**
     * This is a setup function for Activity onCreate, any kind of post setup can go here.
     */
    open fun setup(savedInstanceState: Bundle?) {}

    /**
     * Returns a layout resource used in Activity
     */
    @LayoutRes
    abstract fun getLayoutRes(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectSelf()
        setContentView(getLayoutRes())
        setup(savedInstanceState)
    }
}
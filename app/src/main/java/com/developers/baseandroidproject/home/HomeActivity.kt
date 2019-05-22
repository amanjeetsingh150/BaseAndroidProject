package com.developers.baseandroidproject.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.developers.baseandroidproject.R
import com.developers.baseandroidproject.utils.inject
import javax.inject.Inject

class HomeActivity : AppCompatActivity() {

    @Inject
    lateinit var homeViewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inject(this)
    }
}

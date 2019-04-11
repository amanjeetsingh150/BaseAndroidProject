package com.developers.baseandroidproject.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.developers.baseandroidproject.data.DataManager
import java.lang.IllegalArgumentException
import javax.inject.Inject

class HomeViewModelFactory @Inject constructor(private val dataManager: DataManager) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass != HomeViewModel::class.java)
            throw IllegalArgumentException("Wrong Arguments")
        return HomeViewModel(dataManager) as T
    }
}
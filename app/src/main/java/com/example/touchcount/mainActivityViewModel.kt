package com.example.touchcount

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class mainActivityViewModel:ViewModel() {
    var count=MutableLiveData<Int>()
    init {
        count.value=0
    }

    fun update()
    {
        count.value=count.value?.plus(1)
    }
}
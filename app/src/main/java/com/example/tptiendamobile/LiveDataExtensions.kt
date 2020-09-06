package com.example.tptiendamobile

import androidx.lifecycle.MutableLiveData

fun <T> MutableLiveData<T>.notifyObservers() {
    postValue(this.value)
}
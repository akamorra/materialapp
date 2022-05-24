package com.groke.materialapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.lang.Thread.sleep

class MainViewModel(private val liveData: MutableLiveData<AppState> = MutableLiveData()) :
    ViewModel() {
    fun getData() = liveData

    fun getImage() {
        //LocalRepository.getData()
        //RemoteRepository.getData()
        Thread {
            sleep(1000L)
            liveData.postValue(AppState.Success)
            sleep(3000L)
            liveData.postValue(AppState.Loading)
            sleep(3000L)
            liveData.postValue(AppState.Error("Error"))
        }.start()
    }
}

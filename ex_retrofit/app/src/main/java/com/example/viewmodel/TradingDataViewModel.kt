package com.example.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.example.repository.Repository
import com.example.repository.TradingItem
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class TradingDataViewModel @Inject constructor(application: Application, repository: Repository) : ViewModel() {

    val LAWD_CD ="test"
    val DEAL_YMD = "tesT"
    val serviceKey = "test"

    val TradingDataUsingFlow: LiveData<List<TradingItem>> = repository.getTradingData(LAWD_CD, DEAL_YMD, serviceKey).asLiveData()

}


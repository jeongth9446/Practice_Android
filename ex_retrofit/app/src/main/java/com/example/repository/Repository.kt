package com.example.repository

import com.example.data.Item
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject internal constructor(private val localStorage: LocalStorage, private val remoteStorage: RemoteStorage) {


    fun getTradingData(LAWD_CD: String, DEAL_YMD: String, serviceKey: String): Flow<List<TradingItem>> {
        var tradingdata = localStorage.getTradingData(LAWD_CD, DEAL_YMD)
        if(tradingdata == null) {
            var remoteTradingData = remoteStorage.getTradingData(LAWD_CD, DEAL_YMD, serviceKey)
            for(remoteTradingDataItem: Item in remoteTradingData ) {
                localStorage.insert(remoteTradingDataItem, LAWD_CD, DEAL_YMD)
            }
            tradingdata = localStorage.getTradingData(LAWD_CD, DEAL_YMD)
        }
        return tradingdata
    }

}
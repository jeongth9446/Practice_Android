package com.example.repository

import android.content.Context
import android.util.Log
import com.example.data.GetTradingDataResponse
import com.example.data.Item
import com.tickaroo.tikxml.TikXml
import com.tickaroo.tikxml.retrofit.TikXmlConverterFactory
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Inject

class RemoteStorage @Inject internal constructor(@ApplicationContext context: Context) {

    val call = RetrofitClient.retrofitService

    fun getTradingData(LAWD_CD: String, DEAL_YMD: String, serviceKey: String): List<Item> {
        var data: List<Item> = emptyList()
        call.getPosts(
            LAWD_CD = "11110",
            DEAL_YMD = "202112",
            serviceKey = "jubOkghh%2BVe16E%2BEzdotuLAvoFcS4XiCMCTTbbO1XDFfSVvnEMek%2FuDG8b3V242xQTvzPaOzhDMKcbEyoD2ecw%3D%3D"
        )
            .enqueue(object : Callback<GetTradingDataResponse> {
                override fun onResponse(
                    call: Call<GetTradingDataResponse>,
                    response: Response<GetTradingDataResponse>
                ) {
                    Log.d("retrofit", response.body().toString())
                    data = response.body()!!.body?.items?.item!!
                }

                override fun onFailure(call: Call<GetTradingDataResponse>, t: Throwable) {
                    Log.e("retrofit", t.toString())
                }
            })
        return data
    }
}

object RetrofitClient {
    private val retrofitclient: Retrofit.Builder by lazy {
        Retrofit.Builder()
            .baseUrl("http://openapi.molit.go.kr:8081/OpenAPI_ToolInstallPackage/service/rest/")
            .addConverterFactory(TikXmlConverterFactory.create(TikXml.Builder().exceptionOnUnreadXml(false).build()))
    }
    val retrofitService: RetrofitService by lazy {
        retrofitclient.build().create(RetrofitService::class.java)
    }
}

interface RetrofitService {

    @GET("RTMSOBJSvc/getRTMSDataSvcAptTrade?")
    fun getPosts(@Query("serviceKey", encoded = true) serviceKey: String, @Query("LAWD_CD", encoded = true) LAWD_CD: String, @Query(value = "DEAL_YMD", encoded = true) DEAL_YMD: String): Call<GetTradingDataResponse>
}
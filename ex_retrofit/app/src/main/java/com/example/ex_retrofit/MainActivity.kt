package com.example.ex_retrofit

import android.app.Application
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import com.example.data.Item
import com.example.data.GetTradingDataResponse
import com.example.ex_retrofit.ui.theme.Ex_retrofitTheme
import com.example.repository.Repository
import com.example.repository.RetrofitClient
import com.example.viewmodel.TradingDataViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    lateinit var viewModel: TradingDataViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)
            .get(TradingDataViewModel::class.java)

        setContent {
            Ex_retrofitTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colors.background
                ) {
                    //val data = MutableLiveData<List<Item>>()
                    greeting("android")

                    var data: List<Item> = emptyList()

                    val res = viewModel.TradingDataUsingFlow.observeAsState()

                    Log.d("ss", res.toString())

                    LazyColumn(
                        modifier = Modifier.fillMaxWidth(),
                        contentPadding = PaddingValues(16.dp)
                    ) {
                        items(data) { trading ->
                            TradingListItem(trading)
                        }
                    }

                    //TradingList(tradings = data)
                }
            }
        }
    }
}



@Composable
fun greeting(text: String) {
    Text(text = text)
}

@Composable
fun TradingListItem(trading: Item) {
    Column() {
        Row() {
            trading.DealYear?.let { Text(text = it) }
            Text(text = "??? ")
            trading.DealMonth?.let { Text(text = it) }
            Text(text = "??? ")
            trading.DealDay?.let { Text(text = it) }
            Text(text = "???")
        }
        Row() {
            Text(text ="????????? ")
            Text(text ="?????? ")
            Text(text ="??????????????????????????????")
        }
        Row() {
            Text(text = "???")
        }

    }
}
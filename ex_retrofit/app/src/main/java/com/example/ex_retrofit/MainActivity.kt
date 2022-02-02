package com.example.ex_retrofit

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.common.ForeCastResponse
import com.example.common.RetrofitService
import com.example.ex_retrofit.ui.theme.Ex_retrofitTheme
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.jaxb.JaxbConverterFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Ex_retrofitTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")

                    val retrofit = Retrofit.Builder()
                        .baseUrl("http://data.ex.co.kr/openapi/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                    val server: RetrofitService = retrofit.create(RetrofitService::class.java)

                    server.getForecast("test", "json").enqueue(object : Callback<ForeCastResponse> {
                        override fun onFailure(call: Call<ForeCastResponse>, t: Throwable) {
                            Log.e("retrofit", t.toString())
                        }

                        override fun onResponse(
                            call: Call<ForeCastResponse>,
                            response: Response<ForeCastResponse>
                        ) {
                            Log.d("retrofit", response.body().toString())
                        }
                    })
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Ex_retrofitTheme {
        Greeting("Android")
    }
}
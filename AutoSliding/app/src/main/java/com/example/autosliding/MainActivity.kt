package com.example.autosliding

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.autosliding.model.natural
import com.example.autosliding.ui.theme.AutoSlidingTheme
import androidx.paging.compose


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AutoSlidingTheme {
                Surface(
                    color = MaterialTheme.colors.background
                ) {
                    AutoSliding()
                }
            }
        }
    }
}

@Composable
fun AutoSliding() {

    val lazyPagingItems = flow.collectAsLazyPagingItems()
    LazyColumn {
        items(lazyPagingItems) {
            Text("Item is $it")
        }
    }
}

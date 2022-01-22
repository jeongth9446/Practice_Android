package com.example.myweolbu.ui.theme

import androidx.compose.runtime.Composable
import com.example.myweolbu.*

typealias ComposableFun = @Composable () -> Unit
sealed class TabItem(var icon: Int, var title: String, var Screen: ComposableFun) {
    object Music: TabItem(R.drawable.ic_action_name, "Music", { MusicScreen()} )
    object Movies: TabItem(R.drawable.ic_action_name, "Movies", { MoviesScreen()} )
    object Books: TabItem(R.drawable.ic_action_name, "Books", { BooksScreen()} )
    object Naver: TabItem(R.drawable.ic_action_name, "Naver", { webViewPage(url = "https://www.naver.com")} )
}
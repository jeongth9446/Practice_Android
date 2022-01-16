package com.example.myweolbu.ui.theme

import androidx.compose.runtime.Composable
import com.example.myweolbu.BooksScreen
import com.example.myweolbu.MoviesScreen
import com.example.myweolbu.MusicScreen
import com.example.myweolbu.R

typealias ComposableFun = @Composable () -> Unit
sealed class TabItem(var icon: Int, var title: String, var Screen: ComposableFun) {
    object Music: TabItem(R.drawable.ic_launcher_foreground, "Music", { MusicScreen()} )
    object Movies: TabItem(R.drawable.ic_launcher_foreground, "Movies", { MoviesScreen()} )
    object Books: TabItem(R.drawable.ic_launcher_foreground, "Books", { BooksScreen()} )

}

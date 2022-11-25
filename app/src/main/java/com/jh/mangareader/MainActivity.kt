package com.jh.mangareader

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.jh.mangareader.authorization.ui.screen.NavGraphs
import com.jh.mangareader.ui.theme.MangaReaderTheme
import com.ramcosta.composedestinations.DestinationsNavHost
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MangaReaderTheme() {
                DestinationsNavHost(navGraph = NavGraphs.root)
            }
        }
    }
}
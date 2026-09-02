package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.ui.QuoteScreen
import com.example.ui.QuoteViewModel
import com.example.ui.theme.RandomQuoteTheme

class MainActivity : ComponentActivity() {

    private val quoteViewModel: QuoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RandomQuoteTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    QuoteScreen(viewModel = quoteViewModel)
                }
            }
        }
    }
}

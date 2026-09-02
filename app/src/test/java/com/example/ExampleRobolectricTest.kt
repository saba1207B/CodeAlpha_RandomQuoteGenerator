package com.example

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.example.data.QuoteRepository
import com.example.ui.QuoteViewModel
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [36])
class ExampleRobolectricTest {

    @Test
    fun `read app_name string resource from context`() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val appName = context.getString(R.string.app_name)
        assertEquals("Random Quote Generator", appName)
    }

    @Test
    fun `quote repository has at least 30 high quality quotes`() {
        val quotes = QuoteRepository.allQuotes
        assertTrue("Quotes list should contain at least 30 items", quotes.size >= 30)
        quotes.forEach { quote ->
            assertTrue("Quote text must not be blank", quote.text.isNotBlank())
            assertTrue("Quote author must not be blank", quote.author.isNotBlank())
            assertTrue("Quote category must not be blank", quote.category.isNotBlank())
        }
    }

    @Test
    fun `quote viewModel cycle and favorite logic`() {
        val viewModel = QuoteViewModel()
        val initialQuote = viewModel.uiState.value.currentQuote
        assertNotNull(initialQuote)

        // Test favorite toggle
        val wasFav = viewModel.uiState.value.isFavorite
        viewModel.toggleFavorite()
        assertEquals(!wasFav, viewModel.uiState.value.isFavorite)

        // Test next quote
        viewModel.nextQuote()
        val secondQuote = viewModel.uiState.value.currentQuote
        assertNotNull(secondQuote)

        // Test category filtering
        viewModel.selectCategory("Motivational")
        assertEquals("Motivational", viewModel.uiState.value.selectedCategory)
        assertEquals("Motivational", viewModel.uiState.value.currentQuote.category)
    }
}

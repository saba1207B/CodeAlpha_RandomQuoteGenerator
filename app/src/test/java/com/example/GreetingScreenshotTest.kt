package com.example

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onRoot
import com.example.model.Quote
import com.example.ui.components.QuoteCard
import com.example.ui.theme.RandomQuoteTheme
import com.github.takahirom.roborazzi.RobolectricDeviceQualifiers
import com.github.takahirom.roborazzi.captureRoboImage
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.robolectric.annotation.GraphicsMode

@RunWith(RobolectricTestRunner::class)
@GraphicsMode(GraphicsMode.Mode.NATIVE)
@Config(qualifiers = RobolectricDeviceQualifiers.Pixel8, sdk = [36])
class GreetingScreenshotTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun quoteCard_screenshot() {
        val sampleQuote = Quote(
            id = 1,
            text = "The only way to do great work is to love what you do.",
            author = "Steve Jobs",
            category = "Success"
        )

        composeTestRule.setContent {
            RandomQuoteTheme {
                QuoteCard(
                    quote = sampleQuote,
                    isFavorite = true,
                    onFavoriteToggle = {},
                    onCopyQuote = {},
                    onShareQuote = {}
                )
            }
        }

        composeTestRule.onRoot().captureRoboImage(filePath = "src/test/screenshots/greeting.png")
    }
}

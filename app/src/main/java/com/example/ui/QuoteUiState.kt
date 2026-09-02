package com.example.ui

import com.example.model.Quote

/**
 * UI State for the Random Quote Generator screen.
 *
 * @param currentQuote The quote currently displayed on screen.
 * @param selectedCategory The currently active category filter (e.g. "All", "Motivational").
 * @param categories The list of all available categories.
 * @param isFavorite Whether the current quote is marked as favorite by the user.
 * @param favoriteIds The set of quote IDs currently favorited.
 * @param currentIndex The 1-based index representing how many quotes have been explored in this sequence.
 * @param totalQuotes The total number of quotes in the active category.
 */
data class QuoteUiState(
    val currentQuote: Quote,
    val selectedCategory: String = "All",
    val categories: List<String> = emptyList(),
    val isFavorite: Boolean = false,
    val favoriteIds: Set<Int> = emptySet(),
    val currentIndex: Int = 1,
    val totalQuotes: Int = 0
)

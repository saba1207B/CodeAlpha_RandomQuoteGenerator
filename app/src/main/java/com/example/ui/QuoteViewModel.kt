package com.example.ui

import androidx.lifecycle.ViewModel
import com.example.data.QuoteRepository
import com.example.model.Quote
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

/**
 * ViewModel managing the business logic for the Random Quote Generator.
 * Implements a non-repeating shuffle deck to guarantee every quote in a category
 * is viewed before any repetitions occur.
 */
class QuoteViewModel : ViewModel() {

    private val _favoriteIds = MutableStateFlow<Set<Int>>(emptySet())
    private val _uiState: MutableStateFlow<QuoteUiState>

    // Unvisited deck of quotes for non-repeating random sequence
    private var unvisitedQuotes: MutableList<Quote> = mutableListOf()
    private var quoteViewCounter = 1

    init {
        val defaultCategory = "All"
        val quotes = QuoteRepository.getQuotesByCategory(defaultCategory)
        val shuffled = quotes.shuffled().toMutableList()
        val firstQuote = shuffled.removeAt(0)
        unvisitedQuotes = shuffled

        _uiState = MutableStateFlow(
            QuoteUiState(
                currentQuote = firstQuote,
                selectedCategory = defaultCategory,
                categories = QuoteRepository.categories,
                isFavorite = false,
                favoriteIds = emptySet(),
                currentIndex = 1,
                totalQuotes = quotes.size
            )
        )
    }

    val uiState: StateFlow<QuoteUiState> = _uiState.asStateFlow()

    /**
     * Advances to the next random quote without repeating quotes until all have been shown.
     */
    fun nextQuote() {
        val currentCategory = _uiState.value.selectedCategory
        val availableQuotes = QuoteRepository.getQuotesByCategory(currentCategory)

        if (unvisitedQuotes.isEmpty()) {
            // Replenish the deck and shuffle, ensuring the new first quote is distinct from current
            val currentId = _uiState.value.currentQuote.id
            val newDeck = availableQuotes.shuffled().toMutableList()
            if (newDeck.size > 1 && newDeck.first().id == currentId) {
                // Swap the first element with another to avoid immediate duplicate
                val swapIndex = (1 until newDeck.size).random()
                val temp = newDeck[0]
                newDeck[0] = newDeck[swapIndex]
                newDeck[swapIndex] = temp
            }
            unvisitedQuotes = newDeck
        }

        val nextQuote = unvisitedQuotes.removeAt(0)
        quoteViewCounter++
        val isFav = _favoriteIds.value.contains(nextQuote.id)

        _uiState.update { currentState ->
            currentState.copy(
                currentQuote = nextQuote,
                isFavorite = isFav,
                currentIndex = ((quoteViewCounter - 1) % availableQuotes.size) + 1,
                totalQuotes = availableQuotes.size
            )
        }
    }

    /**
     * Toggles favorite status for the current quote.
     */
    fun toggleFavorite() {
        val currentQuoteId = _uiState.value.currentQuote.id
        val updatedFavorites = if (_favoriteIds.value.contains(currentQuoteId)) {
            _favoriteIds.value - currentQuoteId
        } else {
            _favoriteIds.value + currentQuoteId
        }
        _favoriteIds.value = updatedFavorites

        _uiState.update { currentState ->
            currentState.copy(
                isFavorite = updatedFavorites.contains(currentState.currentQuote.id),
                favoriteIds = updatedFavorites
            )
        }
    }

    /**
     * Filters quotes by selected category and picks a new random quote from that category.
     */
    fun selectCategory(category: String) {
        if (category == _uiState.value.selectedCategory) return

        val quotes = QuoteRepository.getQuotesByCategory(category)
        val shuffled = quotes.shuffled().toMutableList()
        val firstQuote = shuffled.removeAt(0)
        unvisitedQuotes = shuffled
        quoteViewCounter = 1

        val isFav = _favoriteIds.value.contains(firstQuote.id)

        _uiState.update { currentState ->
            currentState.copy(
                currentQuote = firstQuote,
                selectedCategory = category,
                isFavorite = isFav,
                currentIndex = 1,
                totalQuotes = quotes.size
            )
        }
    }
}

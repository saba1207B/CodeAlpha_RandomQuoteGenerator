package com.example.model

/**
 * Data representation of an inspirational quote.
 *
 * @param id Unique identifier for the quote.
 * @param text The quote sentence or statement.
 * @param author The person credited with the quote.
 * @param category The theme or topic of the quote (e.g., Motivation, Wisdom, Life).
 */
data class Quote(
    val id: Int,
    val text: String,
    val author: String,
    val category: String = "Wisdom"
)

package com.example.data

import com.example.model.Quote

/**
 * Repository providing access to a curated collection of inspirational quotes.
 */
object QuoteRepository {

    val categories: List<String> = listOf(
        "All",
        "Motivational",
        "Life",
        "Success",
        "Wisdom",
        "Courage",
        "Creativity"
    )

    val allQuotes: List<Quote> = listOf(
        Quote(
            id = 1,
            text = "The only way to do great work is to love what you do.",
            author = "Steve Jobs",
            category = "Success"
        ),
        Quote(
            id = 2,
            text = "In the middle of every difficulty lies opportunity.",
            author = "Albert Einstein",
            category = "Wisdom"
        ),
        Quote(
            id = 3,
            text = "It does not matter how slowly you go as long as you do not stop.",
            author = "Confucius",
            category = "Motivational"
        ),
        Quote(
            id = 4,
            text = "Life is what happens when you're busy making other plans.",
            author = "John Lennon",
            category = "Life"
        ),
        Quote(
            id = 5,
            text = "Courage is not the absence of fear, but the triumph over it.",
            author = "Nelson Mandela",
            category = "Courage"
        ),
        Quote(
            id = 6,
            text = "Creativity is intelligence having fun.",
            author = "Albert Einstein",
            category = "Creativity"
        ),
        Quote(
            id = 7,
            text = "The future belongs to those who believe in the beauty of their dreams.",
            author = "Eleanor Roosevelt",
            category = "Motivational"
        ),
        Quote(
            id = 8,
            text = "Do not go where the path may lead, go instead where there is no path and leave a trail.",
            author = "Ralph Waldo Emerson",
            category = "Courage"
        ),
        Quote(
            id = 9,
            text = "Success is not final, failure is not fatal: it is the courage to continue that counts.",
            author = "Winston Churchill",
            category = "Success"
        ),
        Quote(
            id = 10,
            text = "You must be the change you wish to see in the world.",
            author = "Mahatma Gandhi",
            category = "Wisdom"
        ),
        Quote(
            id = 11,
            text = "The secret of getting ahead is getting started.",
            author = "Mark Twain",
            category = "Motivational"
        ),
        Quote(
            id = 12,
            text = "To live is the rarest thing in the world. Most people exist, that is all.",
            author = "Oscar Wilde",
            category = "Life"
        ),
        Quote(
            id = 13,
            text = "Everything you've ever wanted is on the other side of fear.",
            author = "George Addair",
            category = "Courage"
        ),
        Quote(
            id = 14,
            text = "If you want to live a happy life, tie it to a goal, not to people or things.",
            author = "Albert Einstein",
            category = "Life"
        ),
        Quote(
            id = 15,
            text = "You cannot use up creativity. The more you use, the more you have.",
            author = "Maya Angelou",
            category = "Creativity"
        ),
        Quote(
            id = 16,
            text = "Happiness is not something ready made. It comes from your own actions.",
            author = "Dalai Lama",
            category = "Wisdom"
        ),
        Quote(
            id = 17,
            text = "Believe you can and you're halfway there.",
            author = "Theodore Roosevelt",
            category = "Motivational"
        ),
        Quote(
            id = 18,
            text = "We are what we repeatedly do. Excellence, then, is not an act, but a habit.",
            author = "Aristotle",
            category = "Success"
        ),
        Quote(
            id = 19,
            text = "An unexamined life is not worth living.",
            author = "Socrates",
            category = "Wisdom"
        ),
        Quote(
            id = 20,
            text = "It always seems impossible until it's done.",
            author = "Nelson Mandela",
            category = "Motivational"
        ),
        Quote(
            id = 21,
            text = "Don't watch the clock; do what it does. Keep going.",
            author = "Sam Levenson",
            category = "Motivational"
        ),
        Quote(
            id = 22,
            text = "The best and most beautiful things in the world cannot be seen or even touched - they must be felt with the heart.",
            author = "Helen Keller",
            category = "Life"
        ),
        Quote(
            id = 23,
            text = "If you hear a voice within you say 'you cannot paint', then by all means paint, and that voice will be silenced.",
            author = "Vincent van Gogh",
            category = "Creativity"
        ),
        Quote(
            id = 24,
            text = "Waste no more time arguing what a good man should be. Be one.",
            author = "Marcus Aurelius",
            category = "Wisdom"
        ),
        Quote(
            id = 25,
            text = "Success usually comes to those who are too busy to be looking for it.",
            author = "Henry David Thoreau",
            category = "Success"
        ),
        Quote(
            id = 26,
            text = "He who is brave is free.",
            author = "Seneca",
            category = "Courage"
        ),
        Quote(
            id = 27,
            text = "Simplicity is the ultimate sophistication.",
            author = "Leonardo da Vinci",
            category = "Creativity"
        ),
        Quote(
            id = 28,
            text = "Your time is limited, so don't waste it living someone else's life.",
            author = "Steve Jobs",
            category = "Life"
        ),
        Quote(
            id = 29,
            text = "You will face many defeats in life, but never let yourself be defeated.",
            author = "Maya Angelou",
            category = "Courage"
        ),
        Quote(
            id = 30,
            text = "The journey of a thousand miles begins with one step.",
            author = "Lao Tzu",
            category = "Motivational"
        ),
        Quote(
            id = 31,
            text = "I have not failed. I've just found 10,000 ways that won't work.",
            author = "Thomas A. Edison",
            category = "Success"
        ),
        Quote(
            id = 32,
            text = "What lies behind us and what lies before us are tiny matters compared to what lies within us.",
            author = "Ralph Waldo Emerson",
            category = "Wisdom"
        ),
        Quote(
            id = 33,
            text = "Turn your wounds into wisdom.",
            author = "Oprah Winfrey",
            category = "Wisdom"
        ),
        Quote(
            id = 34,
            text = "You can't fall if you don't climb. But there's no joy in living your whole life on the ground.",
            author = "Anonymous",
            category = "Courage"
        ),
        Quote(
            id = 35,
            text = "Art is not what you see, but what you make others see.",
            author = "Edgar Degas",
            category = "Creativity"
        ),
        Quote(
            id = 36,
            text = "Hardships often prepare ordinary people for an extraordinary destiny.",
            author = "C.S. Lewis",
            category = "Motivational"
        )
    )

    fun getQuotesByCategory(category: String): List<Quote> {
        return if (category.equals("All", ignoreCase = true)) {
            allQuotes
        } else {
            allQuotes.filter { it.category.equals(category, ignoreCase = true) }
        }
    }
}

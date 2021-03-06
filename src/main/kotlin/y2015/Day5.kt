package y2015

import core.AbstractDay

class Day5(input: List<String>) : AbstractDay(input) {

    override fun calculate(): String = input
        .filter { str -> str.isNice() }
        .count()
        .toString()

    override fun calculateAdvanced(): String = input
        .filter { str -> str.isNiceAdvanced() }
        .count()
        .toString()


    // ===================

    private fun String.isNice(): Boolean = (this.hasAtLeastVowels(3)
        && hasDoubleLetters()
        && !containsAnyOfList("ab", "cd", "pq", "xy"))

    private val VOWELS = "aeiou"
    private fun String.hasAtLeastVowels(amount: Int) = count { c -> VOWELS.contains(c) } >= amount

    private val DOUBLE_LETTERS_PATTERN = ".*(.)\\1.*".toRegex()
    private fun String.hasDoubleLetters() = matches(DOUBLE_LETTERS_PATTERN)

    private fun String.containsAnyOfList(vararg list: String): Boolean {
        list.forEach {
            if (this.contains(it)) return true
        }
        return false
    }


    // ===================

    private fun String.isNiceAdvanced() = hasSameLetterDividedByOne() && hasRepeatingLetterPairs()

    private val DOUBLE_LETTERS_DIVIDED_PATTERN = ".*(.).\\1.*".toRegex()
    private fun String.hasSameLetterDividedByOne() = matches(DOUBLE_LETTERS_DIVIDED_PATTERN)

    private val REPEATING_PAIRS_PATTERN = ".*(..).*\\1.*".toRegex()
    private fun String.hasRepeatingLetterPairs() = matches(REPEATING_PAIRS_PATTERN)
}
package y2015.week5

import core.AbstractDay
import core.extensions.getSumPermutationSet

class Day24(input: List<String>) : AbstractDay(input) {

    override fun calculate(): String {
        return input
            .map { it.toInt() }
            .sortedDescending()
            .getQeForFirstGroup(3)
    }

    override fun calculateAdvanced(): String {
        return input
            .map { it.toInt() }
            .sortedDescending()
            .getQeForFirstGroup(4)
    }

    private fun List<Int>.getQeForFirstGroup(groupCount: Int): String {
        val groupWeight = this.sum() / groupCount

        val firstGroupOptions = this
            .getSumPermutationSet(groupWeight)
            .sortedBy { it.size }

        val smallestSize = firstGroupOptions.first().size

        return firstGroupOptions
            .filter { it.size == smallestSize }
            .map { it.fold(1L) { r, i -> r * i } }
            .sorted()
            .first()
            .toString()
    }
}
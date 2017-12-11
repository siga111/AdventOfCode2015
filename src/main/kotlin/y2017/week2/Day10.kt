package y2017.week2

import core.AbstractDay
import core.extensions.incLooping
import core.extensions.joinWithoutSpaces

class Day10(input: List<String>) : AbstractDay(input) {

    override fun calculate(): String = inputFirstLine.split(",").map { it.toInt() }
        .let { mixUpTimes(it, 1) }
        .let { it[0] * it[1] }
        .toString()

    override fun calculateAdvanced() = inputFirstLineChars.map { it.toInt() }
        .let { it + listOf(17, 31, 73, 47, 23) }
        .let { mixUpTimes(it, 64) }
        .chunked(16)
        .map { it.reduce { c, i -> c.xor(i) } }
        .map { it.toString(16).padStart(2, '0') }
        .joinWithoutSpaces()

    private data class State(
        var skipSize: Int = 0,
        var currentIndex: Int = 0
    )

    private fun mixUpTimes(pinches: List<Int>, times: Int): List<Int> {
        val state = State()
        var list = List(256) { it }
        (0 until times).forEach { list = list.mixListUp(pinches, state) }
        return list
    }

    private fun List<Int>.mixListUp(pinches: List<Int>, state: State): List<Int> {
        var result = this

        pinches.forEach {
            result = result.makeListZeroBased(state.currentIndex)
                .reversePartOfList(it)
                .restoreListToOriginalOrder(state.currentIndex)

            state.currentIndex = state.currentIndex.incLooping(result.size, it + state.skipSize)
            state.skipSize += 1
        }
        return result
    }

    private fun List<Int>.makeListZeroBased(currentIndex: Int) = if (currentIndex != 0) {
        subList(currentIndex, size) + subList(0, currentIndex)
    } else this

    private fun List<Int>.reversePartOfList(reversePartSize: Int) =
        subList(0, reversePartSize).reversed() + subList(reversePartSize, size)

    private fun List<Int>.restoreListToOriginalOrder(currentIndex: Int): List<Int> = if (currentIndex != 0) {
        val i = size - currentIndex
        subList(i, size) + subList(0, i)
    } else this

}
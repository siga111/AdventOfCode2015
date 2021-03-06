package y2015

import core.AbstractDay

class Day14(input: List<String>) : AbstractDay(input) {

    override fun calculate(): String = input.parseReindeer()
        .calculateMovement(2503)
        .map { it.distance }
        .max().toString()

    override fun calculateAdvanced(): String = input.parseReindeer()
        .calculateMovement(2503)
        .map { it.points }
        .max().toString()


    private data class Reindeer(val name: String, val speed: Int, val moveTime: Int, val restTime: Int)

    private data class Movement(val deer: Reindeer, var movesFor: Int, var restsFor: Int, var distance: Int, var points: Int)

    private fun List<String>.parseReindeer() = this.map { str ->
        val tokens = str.split(" ")
        val deer = Reindeer(tokens[0], tokens[3].toInt(), tokens[6].toInt(), tokens[13].toInt())
        Movement(deer, 0, 0, 0, 0)
    }

    private fun List<Movement>.calculateMovement(time: Int): List<Movement> {
        for (second in 1..time) {
            this.forEach {
                when {
                    it.movesFor < it.deer.moveTime -> {
                        it.movesFor++
                        it.distance += it.deer.speed
                    }
                    it.restsFor < it.deer.restTime -> it.restsFor++
                    else -> {
                        it.distance += it.deer.speed
                        it.movesFor = 1
                        it.restsFor = 0
                    }
                }
            }

            val topDistance = this.sortedByDescending { it.distance }.first().distance
            this.forEach { if (it.distance == topDistance) it.points++ }
        }
        return this
    }
}
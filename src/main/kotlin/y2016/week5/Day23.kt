package y2016.week5

import y2016.DayOf2016

class Day23 : DayOf2016("week5/day_23") {

    override fun calculate(): String {
        return input().map { it.split(" ") }
            .executeInstructions(mutableMapOf('a' to 7, 'b' to 0, 'c' to 0, 'd' to 0))
            .get('a')
            ?.toString() ?: ""
    }

    override fun calculateAdvanced(): String {
        return input().map { it.split(" ") }
            .executeInstructions(mutableMapOf('a' to 12, 'b' to 0, 'c' to 0, 'd' to 0))
            .get('a')
            ?.toString() ?: ""
    }


    private fun List<List<String>>.executeInstructions(registers: MutableMap<Char, Int>): MutableMap<Char, Int> {
        val toggles = Array<Boolean>(this.size) { false }

        var counter = 0
        while (counter < this.size) {
            val tokens = this[counter]
            val toggled = toggles[counter]
            counter = when (tokens.command()) {
                "tgl" -> if (!toggled) tgl(counter, registers, toggles, tokens) else inc(counter, registers, tokens)
                "cpy" -> if (!toggled) cpy(counter, registers, tokens) else jnz(counter, registers, tokens)
                "inc" -> if (!toggled) inc(counter, registers, tokens) else dec(counter, registers, tokens)
                "dec" -> if (!toggled) dec(counter, registers, tokens) else inc(counter, registers, tokens)
                "jnz" -> if (!toggled) jnz(counter, registers, tokens) else cpy(counter, registers, tokens)
                else -> 0
            }
            if (counter < 0) counter = 0
        }
        return registers
    }

    private fun tgl(counter: Int, registers: MutableMap<Char, Int>, toggles: Array<Boolean>, tokens: List<String>): Int {
        val i = counter + registers.getOrPut(tokens.firstReg(), { 0 })
        if (i >= 0 && i < toggles.size) toggles[i] = !toggles[i]
        return counter + 1
    }

    private fun inc(counter: Int, registers: MutableMap<Char, Int>, tokens: List<String>): Int {
        val value = registers.getOrPut(tokens.firstReg(), { 0 })
        registers[tokens.firstReg()] = value + 1
        return counter + 1
    }

    private fun dec(counter: Int, registers: MutableMap<Char, Int>, tokens: List<String>): Int {
        val value = registers.getOrPut(tokens.firstReg(), { 0 })
        registers[tokens.firstReg()] = value - 1
        return counter + 1
    }

    private fun cpy(counter: Int, registers: MutableMap<Char, Int>, tokens: List<String>): Int {
        when (tokens.firstReg()) {
            in registers.keys -> {
                registers[tokens.secondReg()] = registers.getOrPut(tokens.firstReg(), { 0 })
            }
            else -> {
                registers[tokens.secondReg()] = tokens.firstValue()
            }
        }
        return counter + 1
    }

    private fun jnz(counter: Int, registers: MutableMap<Char, Int>, tokens: List<String>): Int {
        val flag = when (tokens.firstReg()) {
            in registers.keys -> registers[tokens.firstReg()]!!
            else -> tokens.firstValue()
        }
        val distance = when (tokens.secondReg()) {
            in registers.keys -> registers[tokens.secondReg()]!!
            else -> tokens.secondValue()
        }

        if (flag == 0) {
            return counter + 1
        } else {
            return counter + distance
        }
    }

    fun List<String>.command() = this[0]
    fun List<String>.firstReg() = this[1][0]
    fun List<String>.firstValue() = this[1].toInt()
    fun List<String>.secondReg() = this[2][0]
    fun List<String>.secondValue() = this[2].toInt()

}
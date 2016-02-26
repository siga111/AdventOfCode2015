package days.week3

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 */
class TestDay12 {

    val SIMPLE_ANSWER = "156366"
    val ADVANCED_ANSWER = "96852"

    @Test
    fun testCalculate() {
        assertEquals(SIMPLE_ANSWER, Day12().calculate())
    }

    @Test
    fun testCalculateAdvanced() {
        assertEquals(ADVANCED_ANSWER, Day12().calculateAdvanced())
    }
}
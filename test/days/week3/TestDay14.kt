package days.week3

import days.week3.Day14
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 */
class TestDay14 {

    val SIMPLE_ANSWER = "0"
    val ADVANCED_ANSWER = "0"

    @Test
    fun testCalculate() {
        assertEquals(SIMPLE_ANSWER, Day14().calculate())
    }

    @Test
    fun testCalculateAdvanced() {
        assertEquals(ADVANCED_ANSWER, Day14().calculateAdvanced())
    }
}
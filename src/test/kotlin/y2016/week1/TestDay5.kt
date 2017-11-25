package y2016.week1

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 */
class TestDay5 {

    var SIMPLE_ANSWER = "f77a0e6e"
    val ADVANCED_ANSWER = "999828ec"

    @Test
    fun testCalculate() {
        assertEquals(SIMPLE_ANSWER, Day5().calculate())
    }

    @Test
    fun testCalculateAdvanced() {
        assertEquals(ADVANCED_ANSWER, Day5().calculateAdvanced())
    }
}
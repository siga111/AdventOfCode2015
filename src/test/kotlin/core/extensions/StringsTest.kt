package core.extensions

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class StringsTest {

    @Test
    fun testMd5() {
        assertEquals("000001dbbfa", "abcdef609043".md5Hex().substring(0..10))
        assertEquals("000006136ef", "pqrstuv1048970".md5Hex().substring(0..10))
    }

    @Test
    fun testGetLastWord() {
        assertEquals("test", "test".getLastWord())
        assertEquals("st", "te st".getLastWord())
        assertEquals("t", "t e s t".getLastWord())
    }


}
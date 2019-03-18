package x_or_0

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Tests {

    private val gameField = Xor0(3)

    private val gameField2 = helper()

    private fun helper(): Xor0{
        val testField = Xor0(4)
        testField.setX(1,1);testField.setX(2,2);testField.setX(3,3)
        testField.setX(4,4);testField.setX(2,1);testField.setX(3,1)
        testField.set0(4,1);testField.set0(4,2);testField.set0(4,3)
        testField.set0(1,3);testField.set0(2,4)
        return testField
    }

    @Test
    fun set0(){
        assertTrue(gameField.set0(3,3))
        assertFalse(gameField.set0(5,6))
        assertTrue(gameField.set0(1,1))
    }

    @Test
    fun setX(){
        assertTrue(gameField.setX(1,1))
        assertFalse(gameField.setX(-2,2))
        assertFalse(gameField.setX(6,1))
    }

    @Test
    fun clearCell(){
        assertTrue(gameField.clearCell(1,1))
        assertFalse(gameField.clearCell(-2,2))
        assertFalse(gameField.clearCell(-1,-1))
    }

    @Test
    fun longestXSequence(){
        assertEquals(4,gameField2.longestXSequence())
    }

    @Test
    fun longest0Sequence(){
        assertEquals(3,gameField2.longest0Sequence())
    }
}
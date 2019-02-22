@file:Suppress("UNUSED_PARAMETER", "unused")

package Xor0

import java.lang.IllegalArgumentException

data class Xor0(var size: Int) {

    private val array = MutableList(size) { MutableList(size) { " " } }

    fun setX(x: Int, y: Int){
        if ((x>=1) && (x<=this.size) && (y>=1) && (y<=this.size))
            array[size-y][x - 1] = "X"
        else throw IllegalArgumentException()
    }

    fun set0(x: Int, y: Int){
        if ((x>=1) && (x<=this.size) && (y>=1) && (y<=this.size))
            array[size-y][x - 1] = "0"
        else throw IllegalArgumentException()
    }

    fun clear(x: Int, y: Int){
        if ((x>=1) && (x<=this.size) && (y>=1) && (y<=this.size))
            array[size-y][x - 1] = " "
        else throw IllegalArgumentException()
    }

    fun printField(){
        println(" " + array[0].joinToString(separator = " ║ ") + " ")
        for (i in 1 until size){
            for(k in 0 until size - 1) {
                print("═══╬")
            }
            print("═══")
            println()
            println(" " + array[i].joinToString(separator = " ║ ") + " ")
        }

    }

    fun longestXSequence(): Int{
        var count = 0
        var longestSequence = 0
        for (i in 0 until size) {
                count = array[i].filter { it == "X" }.size - array[i].filter { it == "X" }.toSet().size
            if (count > longestSequence) longestSequence = count
            }
        return longestSequence
    }
}
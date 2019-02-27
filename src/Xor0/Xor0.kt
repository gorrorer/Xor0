@file:Suppress("UNUSED_PARAMETER", "unused")

package Xor0

import java.lang.IllegalArgumentException

class Xor0(var size: Int) {

    private val array = MutableList(size) { MutableList(size) { " " } }

    fun setX(x: Int, y: Int){
        if ((x>=1) && (x<=size) && (y>=1) && (y<=size))
            array[size-y][x - 1] = "X"
        else throw IllegalArgumentException()
    }

    fun set0(x: Int, y: Int){
        if ((x>=1) && (x<=size) && (y>=1) && (y<=size))
            array[size-y][x - 1] = "0"
        else throw IllegalArgumentException()
    }

    fun clear(x: Int, y: Int){
        if ((x>=1) && (x<=size) && (y>=1) && (y<=size))
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
        for (i in 0 until size)
            for(k in 0 until size){
                if (array[i][k] == "X"){
                    for (y in i..0)
                        if (array[y][k] == "X")
                            count++
                    else break
                    if (count > longestSequence) longestSequence = count
                    count = 0
                    for (y in i until size)
                        if (array[y][k] == "X")
                            count++
                        else break
                    if (count > longestSequence) longestSequence = count
                    count = 0
                    for (y in k..0)
                        if (array[i][y] == "X")
                            count++
                        else break
                    if (count > longestSequence) longestSequence = count
                    count = 0
                    for (y in k until size)
                        if (array[i][y] == "X")
                            count++
                        else break
                    if (count > longestSequence) longestSequence = count
                    count = 0
                }
            }
        return longestSequence
    }
}
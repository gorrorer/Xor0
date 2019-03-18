@file:Suppress("UNUSED_PARAMETER", "unused")


package x_or_0


class Xor0(private var size: Int) {


    init { if (size < 0) throw IllegalArgumentException() }


    private val gameField = MutableList(size) { MutableList(size) { " " } }


    private fun set(x: Int, y: Int, type: String): Boolean{
        return if ((x>=1) && (x<=size) && (y>=1) && (y<=size)) {
            gameField[size-y][x - 1] = type
            true
        } else false
    }


    fun set0(x: Int, y: Int): Boolean = set(x, y, "0")


    fun setX(x: Int, y: Int): Boolean = set(x, y, "X")


    fun clearCell(x: Int, y: Int): Boolean = set(x, y, " ")


    fun printField(){           //unnecessary function just for my own convenience
        println(" " + gameField[0].joinToString(separator = " ║ ") + " ")
        for (i in 1 until size){
            for(k in 0 until size - 1) {
                print("═══╬")
            }
            print("═══")
            println()
            println(" " + gameField[i].joinToString(separator = " ║ ") + " ")
        }

    }


    fun longest0Sequence(): Int = longestSequence("0")


    fun longestXSequence(): Int = longestSequence("X")


    private fun longestSequence(type: String): Int{
        var count: Int
        var longestSequence = 0
        for (y in 0 until size) {
            count = 0
            for (x in 0 until size) {   //looking for X horizontal
                if (gameField[y][x] == type)
                    count++
                else {
                    if (count > longestSequence) longestSequence = count
                    count = 0
                }
                if (count > longestSequence) longestSequence = count
            }
        }
        for (x in 0 until size) {   //looking for X vertical
            count = 0
            for (y in 0 until size) {
                if (gameField[y][x] == type)
                    count++
                else {
                    if (count > longestSequence) longestSequence = count
                    count = 0
                }
            }
            if (count > longestSequence) longestSequence = count
        }
        for (i in 0 until size) {                                           //looking for X diagonally
            count = 0                                                       //
            var x = i                                                       //
            var y = 0                                                       //
            while ((x < size) && (y < size)){                               //
                if (gameField[y][x] == type) count++                        //
                else {                                                      //
                    if (count > longestSequence) longestSequence = count    //
                    count = 0                                               //
                }                                                           //
                if (count > longestSequence) longestSequence = count
                x++
                y++
            }
        }
        for (i in 0 until size-1) {
            count = 0
            var x = 0
            var y = i
            while ((x < size) && (y < size)){
                if (gameField[y][x] == type) count++
                else {
                    if (count > longestSequence) longestSequence = count
                    count = 0
                }
                if (count > longestSequence) longestSequence = count
                x++
                y++
            }
        }
        for (i in 0 until size) {
            count = 0
            var x = i
            var y = 0
            while ((x > -1) && (y < size)){
                if (gameField[y][x] == type) count++
                else {
                    if (count > longestSequence) longestSequence = count
                    count = 0
                }
                if (count > longestSequence) longestSequence = count
                x--
                y++
            }
        }
        for (i in 0 until size-1) {
            count = 0
            var x = 3
            var y = i
            while ((x > -1) && (y < size)){
                if (gameField[y][x] == type) count++
                else {
                    if (count > longestSequence) longestSequence = count
                    count = 0
                }
                if (count > longestSequence) longestSequence = count
                x--
                y++
            }
        }
        return longestSequence
    }
}


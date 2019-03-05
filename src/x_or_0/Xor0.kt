@file:Suppress("UNUSED_PARAMETER", "unused")


package x_or_0


class Xor0(private var size: Int) {


    private val array = MutableList(size) { MutableList(size) { " " } }


    fun setX(x: Int, y: Int): Boolean{
        return if ((x>=1) && (x<=size) && (y>=1) && (y<=size)) {
            array[size-y][x - 1] = "X"
            true
        } else false
    }


    fun set0(x: Int, y: Int): Boolean{
        return if ((x>=1) && (x<=size) && (y>=1) && (y<=size)) {
            array[size-y][x - 1] = "0"
            true
        } else false
    }


    fun clearCell(x: Int, y: Int): Boolean{
        return if ((x>=1) && (x<=size) && (y>=1) && (y<=size)) {
            array[size-y][x - 1] = " "
            true
        } else false
    }


    fun printField(){           //unnecessary function just for my own convenience
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
        var count: Int
        var longestSequence = 0
        for (y in 0 until size) {
            count = 0
            for (x in 0 until size) {   //looking for X horizontal
                if (array[y][x] == "X")
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
                if (array[y][x] == "X")
                    count++
                else {
                    if (count > longestSequence) longestSequence = count
                    count = 0
                }
            }
            if (count > longestSequence) longestSequence = count
        }
        for (i in 0 until size) {       //looking for X diagonally
            count = 0
            var x = i
            var y = 0
            while ((x < size) && (y < size)){
                if (array[y][x] == "X") count++
                else {
                    if (count > longestSequence) longestSequence = count
                    count = 0
                }
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
                if (array[y][x] == "X") count++
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
                if (array[y][x] == "X") count++
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
                if (array[y][x] == "X") count++
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


    fun longest0Sequence(): Int{
        var count: Int
        var longestSequence = 0
        for (y in 0 until size) {
            count = 0
            for (x in 0 until size) {   //looking for X horizontal
                if (array[y][x] == "0")
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
                if (array[y][x] == "0")
                    count++
                else {
                    if (count > longestSequence) longestSequence = count
                    count = 0
                }
            }
            if (count > longestSequence) longestSequence = count
        }
        for (i in 0 until size) {
            count = 0
            var x = i
            var y = 0
            while ((x < size) && (y < size)){
                if (array[y][x] == "0") count++
                else {
                    if (count > longestSequence) longestSequence = count
                    count = 0
                }
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
                if (array[y][x] == "0") count++
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
                if (array[y][x] == "0") count++
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
                if (array[y][x] == "0") count++
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


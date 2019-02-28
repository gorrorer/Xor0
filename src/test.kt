
import Xor0.Xor0

fun main(){
    val test = Xor0(4)
    test.setX(4,4)
    test.setX(3,3)
    test.setX(2,2)
    test.printField()
    println(test.longestXSequence())
}
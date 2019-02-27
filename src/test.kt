
import Xor0.Xor0

fun main(){
    val test = Xor0(3)
    test.setX(2,3)
    test.setX(2,2)
    test.printField()
    println(test.longestXSequence())
}
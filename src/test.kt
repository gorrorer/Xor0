
import x_or_0.Xor0

fun main(){
    val test = Xor0(4)
    test.setX(1,1)
    test.setX(2,2)
    test.setX(4,4)
    test.printField()
    println(test.longestXSequence())
}
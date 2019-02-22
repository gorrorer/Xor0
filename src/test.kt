
import Xor0.Xor0

fun main(){
    val field = Xor0(5)
    field.setX(1, 4)
    field.setX(3, 2)
    field.setX(4, 2)
    field.setX(5, 2)
    field.printField()
    println(field.longestXSequence())
}
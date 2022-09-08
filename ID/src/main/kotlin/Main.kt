import java.io.PrintWriter
data class Person(val name: String, val age: Int, val gender: String, val height: Float,
                  val address: String, val contact: Long)
fun main(args: Array<String>) {

    val writer = PrintWriter("ID.csv")

    println("Please enter your name: ")
    val name = readLine()
    println("Please enter your age: ")
    val age = readLine()
    println("Please enter your gender: ")
    val gender = readLine()
    println("Please enter your height: ")s
    val height = readLine()
    println("Please enter your address: ")
    val address = readLine()
    println("Please enter your contact: ")
    val contact = readLine()

    writer.close()






}
import java.io.PrintWriter
/*
import java.io.IOException
import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.StandardOpenOption
*/

data class Person(val name: String,
                  val age: Int,
                  val gender: String,
                  val height: Float,
                  val address: String,
                  val contact: Long,
                  val name2: String,
                  val age2: Int,
                  val gender2: String,
                  val height2: Float,
                  val address2: String,
                  val contact2: Long)
fun main(args: Array<String>) {

    val writer = PrintWriter("ID.csv")

    println("Please enter your name: ")
    val name = readLine()
    println("Please enter your age: ")
    val age = readLine()
    println("Please enter your gender: ")
    val gender = readLine()
    println("Please enter your height: ")
    val height = readLine()
    println("Please enter your address: ")
    val address = readLine()
    println("Please enter your contact: ")
    val contact = readLine()

    writer.append("Name\t")
    writer.append("Age\t")
    writer.append("Gender\t")
    writer.append("Height\t")
    writer.append("Address\t")
    writer.append("Contact\t\n")

    writer.append("$name\t")
    writer.append("$age\t")
    writer.append("$gender\t")
    writer.append("$height\t")
    writer.append("$address\t")
    writer.append("$contact\t\n")

    println("Please enter your name: ")
    val name2 = readLine()
    println("Please enter your age: ")
    val age2 = readLine()
    println("Please enter your gender: ")
    val gender2 = readLine()
    println("Please enter your height: ")
    val height2 = readLine()
    println("Please enter your address: ")
    val address2 = readLine()
    println("Please enter your contact: ")
    val contact2 = readLine()

    writer.append("$name2\t")
    writer.append("$age2\t")
    writer.append("$gender2\t")
    writer.append("$height2\t")
    writer.append("$address2\t")
    writer.append("$contact2\t\n")




    writer.close()


    /*user2()*/
}
/*
data class Person2(val name2: String,
                  val age2: Int,
                  val gender2: String,
                  val height2: Float,
                  val address2: String,
                  val contact2: Long)
fun user2(){
    val writer = PrintWriter("ID.csv")

    println("Please enter your name: ")
    val name2 = readLine()
    println("Please enter your age: ")
    val age2 = readLine()
    println("Please enter your gender: ")
    val gender2 = readLine()
    println("Please enter your height: ")
    val height2 = readLine()
    println("Please enter your address: ")
    val address2 = readLine()
    println("Please enter your contact: ")
    val contact2 = readLine()



    writer.append("$name2\n\n\t")
    writer.append("$age2\t")
    writer.append("$gender2\t")
    writer.append("$height2\t")
    writer.append("$address2\t")
    writer.append("$contact2\t\n")

    writer.close()
}

*/





import model.Person
import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter


fun main(args: Array<String>) {
    val file = File("./ID.csv")
    checkAndInitHeader(file)

    val person = Person()
    println("Please enter your name: ")
    person.name = readLine() ?: "Default Name"
    println("Please enter your age: ")
    person.age = readLine()?.toInt() ?: 0
    println("Please enter your gender: ")
    person.gender = readLine() ?: "Default Gender"
    println("Please enter your height: ")
    person.height = readLine()?.toFloat() ?: 0F
    println("Please enter your address: ")
    person.address = readLine() ?: "Default Address"
    println("Please enter your contact: ")
    person.contact = readLine() ?: "Default Contact"

    val writtableData = person.toCSVData()
    writeData(file, writtableData)
}

private fun checkAndInitHeader(file: File) {
    val firstLine = file.useLines { it.firstOrNull() }
    val header = "Name,Age,Gender,Height,Address,Contact"
    firstLine?.let {
        if (it != header) { initHeader(file, header) }
        else { println("PROC ==> Header already initialized for ID.csv") }
    } ?: initHeader(file, header)
}

private fun initHeader(file: File, header: String){
    println("PROC ==> Starting Initialized Header for ID.csv ...!")
    writeData(file, header)
    println("PROC ==> Done Initialized Header for ID.csv!")
}

private fun writeData(file: File, content: String) {
    val fileWriter = FileWriter(file, true)
    val bufferedWriter = BufferedWriter(fileWriter)
    bufferedWriter.write(content)
    bufferedWriter.close()
}




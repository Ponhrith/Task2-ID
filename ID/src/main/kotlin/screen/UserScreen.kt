package screen

import helper.FileHelper
import model.Person
import java.io.File
import kotlin.system.exitProcess

class UserScreen {

    private fun insertUser(file: File) {
        val person = Person()
        print("Please enter your name: ")
        person.name = readLine() ?: "Default Name"
        print("Please enter your age: ")
        person.age = readLine()?.toInt() ?: 0
        print("Please enter your gender: ")
        person.gender = readLine() ?: "Default Gender"
        print("Please enter your height: ")
        person.height = readLine()?.toFloat() ?: 0F
        print("Please enter your address: ")
        person.address = readLine() ?: "Default Address"
        print("Please enter your contact: ")
        person.contact = readLine() ?: "Default Contact"

        FileHelper.writeData(file, person.toCSVData())
    }

    fun insertUserOperation(file: File) {
        print("Put 'q' to quit and put any keys to continue insert user: ")
        when(readLine() ?: "y") {
            "q" -> { return }
            else -> {
                insertUser(file)
                insertUserOperation(file)
            }
        }
    }
}
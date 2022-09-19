package screen

import helper.FileHelper
import model.Person
import java.io.File

class UserScreen {

    fun insertUser(file: File) {
        val person = Person()
        print("Please enter your name: ")
        person.name = readLine()?: "Default Name"
        print("Please enter your age: ")
        person.age = Person.getAgeFromInput()
        print("Please enter your gender: ")
        person.gender = readLine()?: "Default Gender"
        print("Please enter your height: ")
        person.height = Person.getHeightFromInput()
        print("Please enter your address: ")
        person.address = readLine()?: "Default Address"
        print("Please enter your contact: ")
        person.contact = readLine()?: "Default Contact"

        FileHelper.writeData(file, person.toCSVData())
        FileHelper.readData(file)
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

    fun insertUserOperationNonRecursive(file: File) {
        print("Put 'q' to quit and put any keys to continue insert user: ")
        when(readLine() ?: "y") {
            "q" -> { return }
            else -> {
                FileHelper.checkOptionsWhenStart(file)
            }
        }
    }





}
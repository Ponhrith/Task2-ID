package screen

import helper.FileHelper
import model.Options
import model.Person
import java.io.File


class UserScreen {

    private fun insertUser(file: File) {
        val person = Person()
        print("Please enter your name: ")
        person.name = readLine() ?: "Default Name"
        print("Please enter your age: ")
        person.age = Person.getAgeFromInput()
        print("Please enter your gender: ")
        person.gender = readLine() ?: "Default Gender"
        print("Please enter your height: ")
        person.height = Person.getHeightFromInput()
        print("Please enter your address: ")
        person.address = readLine() ?: "Default Address"
        print("Please enter your contact: ")
        person.contact = readLine() ?: "Default Contact"

        FileHelper.writeData(file, person.toCSVData())
        FileHelper.readData(file)
    }

    fun insertUserOperation(file: File) {
        print("Put 'q' to quit and put any keys to go back to main menu: ")
        when (readLine() ?: "y") {
            "q" -> {
                return
            }

            else -> {
                insertUser(file)
                insertUserOperation(file)
            }
        }
    }

    private fun insertUserOperationNonRecursive(file: File) {
        print("Put 'q' to quit and put any keys to go back to main menu: ")
        when (readLine() ?: "y") {
            "q" -> {
                return
            }

            else -> {
                checkOptionsWhenStart(file)
            }
        }
    }

    fun checkOptionsWhenStart(file: File) {
        val option = Options()
        println("1. Click (1) to read the file.")
        println("2. Click (2) to insert the data.")
        option.userChoice = readLine() ?: "Default Option"
        if (option.userChoice == "1") {
            FileHelper.readData(file)
            insertUserOperationNonRecursive(file)

        } else if (option.userChoice == "2") {
            insertUser(file)
            insertUserOperation(file)

        } else {
            println("Invalid Option")
            checkOptionsWhenStart(file)
        }


    }
}
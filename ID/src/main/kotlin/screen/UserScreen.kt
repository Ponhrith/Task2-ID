package screen

import helper.FileHelper
import helper.FileHelper.HEADER
import model.Options
import model.Person
import java.io.File
import java.lang.StringBuilder






class UserScreen {

    var people: MutableList<Person> = mutableListOf()

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
        people = FileHelper.fetchData(file)
    }

    private fun insertUserOperation(file: File) {
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

    private fun backToMainMenu(file: File) {
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

    private fun searchUser(file: File) {
        val option = Options()
        println(
            "-> Search user by:\n" +
                    "1. Name\n" +
                    "2. Age\n" +
                    "3. Gender\n" +
                    "4. Height\n" +
                    "5. Address\n" +
                    "6. Contact"
        )
        option.searchUser = readLine() ?: "1"
        print("-> Please input query: ")
        val query = readLine() ?: ""
        val result = when (option.searchUser) {
            "1" -> people.filter { it.name.contains(query) }
            "2" -> people.filter { it.age == query.toInt() }
            "3" -> people.filter { it.gender == query }
            "4" -> people.filter { it.height == query.toFloat() }
            "5" -> people.filter { it.address.contains(query) }
            "6" -> people.filter { it.contact.contains(query) }
            else -> null
        }
        println("Found People:")
        val stringBuilder = StringBuilder()
        HEADER.split(",").forEach { item ->
            stringBuilder.append(String.format("%20s", item))
        }
        println(stringBuilder)
        result?.forEach {
            println(it.print())
        }
    }


    private fun readFileFromRam(file: File) {
        FileHelper.fetchData(file)
        val stringBuilder = StringBuilder()
        HEADER.split(",").forEach{item ->
            stringBuilder.append(String.format("%20s", item))
        }

        println(stringBuilder)

        for (line in FileHelper.fetchData(file))

            println(line.print())
    }


        fun checkOptionsWhenStart(file: File) {
            val option = Options()
            println("1. Click (1) to read the file.")
            println("2. Click (2) to insert the data.")
            println("3. Click (3) to search the user data.")
            println("4. Click (4) to read data from ram.")
            option.userChoice = readLine() ?: "1"
            when (option.userChoice) {
                "1" -> {
                    FileHelper.readData(file)
                    backToMainMenu(file)
                }

                "2" -> {
                    insertUser(file)
                    backToMainMenu(file)
                }

                "3" -> {
                    searchUser(file)
                    backToMainMenu(file)
                }
                "4" -> {
                    readFileFromRam(file)
                    backToMainMenu(file)
                }

                else -> {
                    println("Invalid Option")
                    checkOptionsWhenStart(file)
                }
            }
        }
}

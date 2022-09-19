package helper

import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter
import java.io.FileReader
import java.io.BufferedReader
import model.Options
import screen.UserScreen
import java.lang.StringBuilder


object FileHelper {

    private const val HEADER = "Name,Age,Gender,Height,Address,Contact"

    fun checkOptionsWhenStart(file: File){
        val option = Options()
        println("1. Click (1) to read the file.")
        println("2. Click (2) to insert the data.")
        option.userChoice = readLine() ?: "Default Option"
        if (option.userChoice == "1"){
            readData(file)
            UserScreen().insertUserOperationNonRecursive(file)

        }else if (option.userChoice =="2"){
            UserScreen().insertUser(file)
            UserScreen().insertUserOperationNonRecursive(file)
        }else {
            println("Invalid Option")
            checkOptionsWhenStart(file)
        }


    }

    fun checkAndInitHeader(file: File) {
        val firstLine = file.useLines { it.firstOrNull() }
        firstLine?.let {
            if (it != HEADER) { initHeader(file) }
            else { println("PROC ==> Header already initialized for ID.csv") }
        } ?: initHeader(file)
    }

    private fun initHeader(file: File){
        println("PROC ==> Starting Initialized Header for ID.csv ...!")
        writeData(file, HEADER)
        println("PROC ==> Done Initialized Header for ID.csv!")
    }

    fun writeData(file: File, content: String) {
        val fileWriter = FileWriter(file, true)
        val bufferedWriter = BufferedWriter(fileWriter)
        bufferedWriter.write(content)
        bufferedWriter.close()
    }

    fun readData(file: File){
        val fileReader = FileReader(file)
        val bufferedReader = BufferedReader(fileReader)
        for (line in bufferedReader.lines()){
            val stringBuilder = StringBuilder()
            line.split(",").forEach {item ->
                stringBuilder.append(String.format("%20s", item))
            }
            println(stringBuilder)
        }
        bufferedReader.close()
    }




}
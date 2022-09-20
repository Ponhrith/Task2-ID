package helper

import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter
import java.io.FileReader
import java.io.BufferedReader

import java.lang.StringBuilder


object FileHelper {

    private const val HEADER = "Name,Age,Gender,Height,Address,Contact"


    fun checkAndInitHeader(file: File) {
        val firstLine = file.useLines { it.firstOrNull() }
        firstLine?.let {
            if (it != HEADER) { initHeader(file) }
            else { println("PROC ==> Header already initialized for ID.csv") }
        }
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
package helper

import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter

object FileHelper {

    private const val HEADER = "Name,Age,Gender,Height,Address,Contact"

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
}
import helper.FileHelper
import screen.UserScreen
import java.io.File


fun main(args: Array<String>) {
    val file = File("./ID.csv")
    FileHelper.checkAndInitHeader(file)


    UserScreen().insertUserOperation(file)
    println("===> Application has shut down")
}
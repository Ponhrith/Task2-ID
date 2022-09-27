import helper.FileHelper
import screen.UserScreen
import java.io.File


fun main(args: Array<String>) {
    val file = File("./ID.csv")
    FileHelper.checkAndInitHeader(file)

    val userScreen = UserScreen()
    userScreen.people = FileHelper.fetchData(file)
    userScreen.checkOptionsWhenStart(file)
    println("===> Application has shut down")
}


package model

data class Person(
    var name: String = "",
    var age: Int = 0,
    var gender: String = "",
    var height: Float = 0F,
    var address: String = "",
    var contact: String = "",
) {
    fun toCSVData() : String{
        return "\n$name,$age,$gender,$height,$address,$contact"
    }

    companion object {
        fun getAgeFromInput() : Int {
            return kotlin.runCatching {
                readLine()?.toInt() ?: 0
            }.onFailure {
                print("Invalid input age, please input age again: ")
            }.getOrElse { getAgeFromInput() }
        }

        fun getHeightFromInput(): Float {
            return kotlin.runCatching{
                readLine()?.toFloat() ?: 0F
            }.onFailure{
                print("Invalid input height, please input the height again: ")
            }.getOrElse{getHeightFromInput()}
        }
    }
}

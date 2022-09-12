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
}

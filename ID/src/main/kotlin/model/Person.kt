package model

import helper.Extension.addSpace
import helper.InputHelper.getFloatFromInput
import helper.InputHelper.getIntFromInput

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

    fun print() : String {
        return "${name.addSpace()}${age.addSpace()}${gender.addSpace()}" +
                "${height.addSpace()}${address.addSpace()}${contact.addSpace()}"
    }

    companion object {
        fun getAgeFromInput() : Int = getIntFromInput(Person::age.name)

        fun getHeightFromInput(): Float = getFloatFromInput(Person::height.name)

    }


}

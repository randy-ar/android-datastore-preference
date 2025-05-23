package edu.unikom.loginlogoutproject

data class UserData(
    val nama: String,
    val email: String,
    val phone: String
) {
    fun isDataNull() : Boolean {
        if (nama == "" || email == "" || phone == "") {
            return true
        } else {
            return false
        }
    }
}

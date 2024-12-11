package com.dikin.shoppingapp.oop

class User(val name: String, val age: Int, private val country: String = "Kazakhstan") {

    fun getInfo(): String {
        return "User: $name, Age: $age, Country: $country"
    }

    constructor(name: String) : this(name, 0)
}

fun main() {
    val user = User("Jhon", 42, "Morocco")
    val user2 = User(name = "Emanuel", age = 35)
    val user3 = User("Samanta")
    println(user.getInfo())
    println(user2.getInfo())
    println(user3.getInfo())
}
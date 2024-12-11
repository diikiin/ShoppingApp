package com.dikin.shoppingapp.oop

interface Draw {
    fun draw()
}

open class Shape : Draw {
    override fun draw() {
        println("This is a shape")
    }
}

class Triangle : Shape() {
    override fun draw() {
        println("This is a triangle")
    }
}

class Rectangle : Shape() {
    override fun draw() {
        println("This is a rectangle")
    }
}

fun main() {
    val triangle = Triangle()
    val rectangle = Rectangle()
    triangle.draw()
    rectangle.draw()
}
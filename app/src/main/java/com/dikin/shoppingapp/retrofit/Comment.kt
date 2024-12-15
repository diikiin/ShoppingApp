package com.dikin.shoppingapp.retrofit

data class Comment(
    val id: Long,
    val body: String,
    val postId: Long,
    val likes: Int,
    val user: User
)

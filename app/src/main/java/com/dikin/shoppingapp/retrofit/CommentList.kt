package com.dikin.shoppingapp.retrofit

data class CommentList(
    val comments: List<Comment>,
    val total: Int,
    val skip: Int,
    val limit: Int
)
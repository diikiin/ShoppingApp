package com.dikin.shoppingapp.retrofit

import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface CommentService {
    @GET("/comments")
    suspend fun getAll(@Query("limit") limit: Int, @Query("skip") skip: Int): CommentList

    @POST("/comments/add")
    suspend fun create(@Body comment: Comment): Comment

    @PUT("/comments/{id}")
    suspend fun update(@Path("id") id: Int, @Body comment: Comment): Comment

    @DELETE("/comments/{id}")
    suspend fun delete(@Path("id") id: Int)
}
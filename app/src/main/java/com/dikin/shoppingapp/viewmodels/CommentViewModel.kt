package com.dikin.shoppingapp.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.dikin.shoppingapp.config.RetrofitInstance
import com.dikin.shoppingapp.retrofit.ApiResponse
import com.dikin.shoppingapp.retrofit.CommentList
import com.dikin.shoppingapp.retrofit.CommentService
import kotlinx.coroutines.launch

class CommentViewModel(application: Application) : AndroidViewModel(application) {

    private val service = RetrofitInstance.createService(CommentService::class.java)
    private val _commentsState = MutableLiveData<ApiResponse<CommentList>>()
    val commentsState: LiveData<ApiResponse<CommentList>> get() = _commentsState

    init {
        fetchComments()
    }

    private fun fetchComments() = viewModelScope.launch {
        _commentsState.value = ApiResponse.Loading
        _commentsState.value = try {
            val limit = (0..5).random()
            val skip = (0..10).random()
            val commentList = service.getAll(limit, skip)
            ApiResponse.Success(commentList)
        } catch (e: Exception) {
            Log.e("PRODUCTS", e.message, e)
            ApiResponse.Error("Failed to get tasks", e)
        }
    }
}
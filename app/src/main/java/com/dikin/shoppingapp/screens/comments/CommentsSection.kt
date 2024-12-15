package com.dikin.shoppingapp.screens.comments

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dikin.shoppingapp.retrofit.ApiResponse
import com.dikin.shoppingapp.retrofit.CommentList
import com.dikin.shoppingapp.viewmodels.CommentViewModel

@Composable
fun CommentsSection(
    modifier: Modifier = Modifier,
    commentViewModel: CommentViewModel = viewModel()
) {
    val commentsState by commentViewModel.commentsState.observeAsState(ApiResponse.Loading)

    when (commentsState) {
        is ApiResponse.Loading -> CircularProgressIndicator(modifier = modifier.fillMaxSize())

        is ApiResponse.Success -> CommentsList(
            commentList = (commentsState as ApiResponse.Success<CommentList>).data,
            modifier = modifier.fillMaxSize()
        )

        is ApiResponse.Error -> {
            Column(modifier = modifier.fillMaxSize()) {
                Text(
                    text = (commentsState as ApiResponse.Error).message,
                    color = Color.Red,
                    modifier = Modifier.fillMaxSize(),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}
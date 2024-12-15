package com.dikin.shoppingapp.screens.comments

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.dikin.shoppingapp.retrofit.CommentList
import com.dikin.shoppingapp.screens.PageTitle

@Composable
fun CommentsList(
    commentList: CommentList,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
    ) {
        PageTitle("Comments")

        LazyColumn {
            items(commentList.comments) { comment ->
                CommentItem(
                    comment = comment
                )
            }
        }
    }
}
package com.example.weeksevensq012ikechiu.service;

import com.example.weeksevensq012ikechiu.model.response.ApiResponse;
import com.example.weeksevensq012ikechiu.model.response.CommentLikeRest;

public interface CommentLikeService {
    ApiResponse<CommentLikeRest> updateCommentLike(Long commentId, Long postId, String userId);
}

package com.example.weeksevensq012ikechiu.service;

import com.example.weeksevensq012ikechiu.model.response.ApiResponse;
import com.example.weeksevensq012ikechiu.model.response.CommentRest;
import com.example.weeksevensq012ikechiu.model.response.OperationStatus;
import com.example.weeksevensq012ikechiu.shared.dto.CommentDto;

import java.util.List;

public interface CommentService {
    ApiResponse<CommentRest> comment(CommentDto commentDto, String userId, Long postId);
    ApiResponse<CommentRest> updateComment(CommentDto commentDto, String userId, Long postId, Long commentId);
    ApiResponse getCommentById(String userId, Long postId, Long commentId);

    ApiResponse<List<CommentRest>> getComments(String userId, Long postId, int cPage, int cLimit);

    ApiResponse deleteComment(String userId, Long postId, Long commentId);
}

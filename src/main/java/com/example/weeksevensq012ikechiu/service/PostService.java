package com.example.weeksevensq012ikechiu.service;

import com.example.weeksevensq012ikechiu.model.response.ApiResponse;
import com.example.weeksevensq012ikechiu.model.response.OperationStatus;
import com.example.weeksevensq012ikechiu.model.response.PostRest;

import java.util.List;

public interface PostService {
    ApiResponse<PostRest> createPost(String userId, String post);
    ApiResponse<PostRest> updatePost(String userId, Long postId, String post);
    ApiResponse<List<PostRest>> getPosts(String userId, int page, int limit, int cPage, int cLimit);
    ApiResponse<PostRest> getPost(String userId, Long postId, int cPage, int cLimit);
    ApiResponse<OperationStatus> deletePost(Long postId, String userId);

}

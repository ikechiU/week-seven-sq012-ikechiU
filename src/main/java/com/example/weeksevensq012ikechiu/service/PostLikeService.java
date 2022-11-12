package com.example.weeksevensq012ikechiu.service;

import com.example.weeksevensq012ikechiu.model.response.ApiResponse;
import com.example.weeksevensq012ikechiu.model.response.PostLikeRest;

public interface PostLikeService {
    ApiResponse<PostLikeRest> updatePostLike(Long postId, String userId);
}

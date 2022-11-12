package com.example.weeksevensq012ikechiu.controllers.rest;

import com.example.weeksevensq012ikechiu.model.request.User;
import com.example.weeksevensq012ikechiu.model.response.ApiResponse;
import com.example.weeksevensq012ikechiu.model.response.PostLikeRest;
import com.example.weeksevensq012ikechiu.model.response.UserRest;
import com.example.weeksevensq012ikechiu.service.impl.PostLikeServiceImpl;
import com.example.weeksevensq012ikechiu.shared.dto.UserDto;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class PostLikeController {

    private final PostLikeServiceImpl postLikeService;

    @PutMapping(path = "/{userId}/post/{postId}/post-like",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ApiResponse<PostLikeRest> updatePostLike(@PathVariable String userId, @PathVariable Long postId) {
        return postLikeService.updatePostLike(postId, userId);
    }

}

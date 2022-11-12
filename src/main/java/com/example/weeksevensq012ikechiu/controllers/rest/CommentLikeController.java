package com.example.weeksevensq012ikechiu.controllers.rest;

import com.example.weeksevensq012ikechiu.model.request.Login;
import com.example.weeksevensq012ikechiu.model.request.User;
import com.example.weeksevensq012ikechiu.model.response.ApiResponse;
import com.example.weeksevensq012ikechiu.model.response.CommentLikeRest;
import com.example.weeksevensq012ikechiu.model.response.OperationStatus;
import com.example.weeksevensq012ikechiu.model.response.UserRest;
import com.example.weeksevensq012ikechiu.service.impl.CommentLikeServiceImpl;
import com.example.weeksevensq012ikechiu.service.impl.UserServiceImpl;
import com.example.weeksevensq012ikechiu.shared.dto.UserDto;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class CommentLikeController {

    private final CommentLikeServiceImpl commentLikeService;

    @PutMapping(path = "/{userId}/post/{postId}/comment/{commentId}/comment-like",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ApiResponse<CommentLikeRest> updateCommentLike(@PathVariable Long commentId, @PathVariable Long postId,
                                                          @PathVariable String userId) {
        return commentLikeService.updateCommentLike(commentId, postId, userId);
    }


}

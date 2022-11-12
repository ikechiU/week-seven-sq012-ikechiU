package com.example.weeksevensq012ikechiu.controllers.rest;

import com.example.weeksevensq012ikechiu.model.request.Comment;
import com.example.weeksevensq012ikechiu.model.response.ApiResponse;
import com.example.weeksevensq012ikechiu.model.response.CommentRest;
import com.example.weeksevensq012ikechiu.service.impl.CommentServiceImpl;
import com.example.weeksevensq012ikechiu.shared.dto.CommentDto;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class CommentController {

    private final CommentServiceImpl commentService;
    private final ModelMapper modelMapper;

    @PostMapping(path = "/{userId}/post/{postId}/comment", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ApiResponse<CommentRest> comment(@PathVariable String userId, @PathVariable Long postId, @RequestBody Comment comment) {
        CommentDto commentDto = new CommentDto();
        BeanUtils.copyProperties(comment, commentDto);
        return commentService.comment(commentDto, userId, postId);
    }

    @PutMapping(path = "/{userId}/post/{postId}/comment/{commentId}", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ApiResponse<CommentRest> updateComment(@PathVariable String userId, @PathVariable Long postId,
                                        @PathVariable Long commentId, @RequestBody Comment comment) {
        CommentDto commentDto = new CommentDto();
        BeanUtils.copyProperties(comment, commentDto);
        return commentService.updateComment(commentDto, userId, postId, commentId);
    }

    @GetMapping(path = "/{userId}/post/{postId}/comment/{commentId}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ApiResponse getCommentById(@PathVariable String userId, @PathVariable Long postId,
                                                   @PathVariable Long commentId) {
        return commentService.getCommentById(userId, postId, commentId);
    }

    @GetMapping(path = "/{userId}/post/{postId}/comment",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ApiResponse<List<CommentRest>> getComments(@PathVariable String userId, @PathVariable Long postId,
                                                   @RequestParam(value = "cPage", defaultValue = "0") int cPage,
                                   @RequestParam(value = "cLimit", defaultValue = "5") int cLimit) {
        return commentService.getComments(userId, postId, cPage, cLimit);
    }

    @DeleteMapping(path = "/{userId}/post/{postId}/comment/{commentId}/delete",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ApiResponse deleteComment(@PathVariable String userId, @PathVariable Long postId,
                                     @PathVariable Long commentId) {
        return commentService.deleteComment(userId, postId, commentId);
    }

}

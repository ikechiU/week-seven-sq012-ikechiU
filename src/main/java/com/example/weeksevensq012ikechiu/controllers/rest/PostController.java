package com.example.weeksevensq012ikechiu.controllers.rest;

import com.example.weeksevensq012ikechiu.model.request.Login;
import com.example.weeksevensq012ikechiu.model.request.User;
import com.example.weeksevensq012ikechiu.model.response.ApiResponse;
import com.example.weeksevensq012ikechiu.model.response.OperationStatus;
import com.example.weeksevensq012ikechiu.model.response.PostRest;
import com.example.weeksevensq012ikechiu.model.response.UserRest;
import com.example.weeksevensq012ikechiu.service.impl.PostServiceImpl;
import com.example.weeksevensq012ikechiu.shared.dto.UserDto;
import lombok.AllArgsConstructor;
import org.json.JSONObject;
import org.modelmapper.ModelMapper;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class PostController {

    private final PostServiceImpl postService;

    @PostMapping(path = "/{userId}/post", consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ApiResponse<PostRest> createPost(@PathVariable String userId, @RequestBody String post) {
        JSONObject object = new JSONObject(post);
        return postService.createPost(userId, (String) object.get("post"));
    }

    @PutMapping(path = "/{userId}/post/{postId}", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ApiResponse<PostRest> updatePost(@PathVariable String userId, @PathVariable Long postId, @RequestBody String post) {
        return postService.updatePost(userId, postId, post);
    }

    @GetMapping(path = "/{userId}/post", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ApiResponse<List<PostRest>> getPosts(@PathVariable String userId, @RequestParam(value = "page", defaultValue = "0") int page,
                                                @RequestParam(value = "limit", defaultValue = "5") int limit,
                                                @RequestParam(value = "cPage", defaultValue = "0") int cPage,
                                                @RequestParam(value = "cLimit", defaultValue = "5") int cLimit) {
        return postService.getPosts(userId, page, limit, cPage, cLimit);
    }

    @GetMapping(path = "/{userId}/post/{postId}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ApiResponse<PostRest> getPost(@PathVariable String userId, @PathVariable Long postId,
                                                 @RequestParam(value = "cPage", defaultValue = "0") int cPage,
                                                 @RequestParam(value = "cLimit", defaultValue = "5") int cLimit) {
        return postService.getPost(userId, postId, cPage, cLimit);
    }

    @DeleteMapping(path = "/{userId}/post/{postId}/delete", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ApiResponse<OperationStatus> deletePost(@PathVariable String userId, @PathVariable Long postId) {
        return postService.deletePost(postId, userId);
    }

}

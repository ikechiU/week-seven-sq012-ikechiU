package com.example.weeksevensq012ikechiu.controllers.web;

import com.example.weeksevensq012ikechiu.io.entity.UserEntity;
import com.example.weeksevensq012ikechiu.model.request.Comment;
import com.example.weeksevensq012ikechiu.model.request.Login;
import com.example.weeksevensq012ikechiu.model.request.Post;
import com.example.weeksevensq012ikechiu.model.response.UserRest;
import com.example.weeksevensq012ikechiu.service.impl.*;
import com.example.weeksevensq012ikechiu.shared.dto.CommentDto;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
public class HomepageController {

    private UserServiceImpl userService;
    private PostServiceImpl postService;
    private PostLikeServiceImpl postLikeService;

    private CommentServiceImpl commentService;
    private CommentLikeServiceImpl commentLikeService;
    private ModelMapper modelMapper;

    @GetMapping("/homepage/{userId}")
    public String index(@PathVariable("userId") String userId, Model model) {
        var userEntity = userService.getUserById(userId);

        var userRest = modelMapper.map(userEntity, UserRest.class);
        var postResponse = postService.getPosts(userRest.getUserId(), 1, 10, 1, 10);
        var postRest = postResponse.getData();
        model.addAttribute("userRest", userRest);
        model.addAttribute("postRest", postRest);
        return "homepage";
    }

//    @PostMapping("/homepage/{userId}")
//    public String index(@PathVariable("userId") String userId, Post post) {
//        String newPost = post.getPost();
//        System.out.println("USER ID: " + post.getUserId());
////        String userId = post.getUserId();
//        postService.createPost(userId, newPost);
//        return "redirect:/homepage/" + userId;
//    }

    @PostMapping("/homepage/post")
    public String index(@RequestParam(value="userId",required=false) String userId,
                        @RequestParam(value="post",required=false) String post) {
        postService.createPost(userId, post);
        return "redirect:/homepage/" + userId;
    }


    ///homepage(userId=${userId})/post(postId=${tempPost.id})/post-like
    @GetMapping("homepage/post/post-like")
    public String postLike(@RequestParam("userId") String userId, @RequestParam("postId") String postId) {
        System.out.println("USER ID: " + userId);
        System.out.println("POST ID: " + postId);
        postLikeService.updatePostLike(Long.parseLong(postId), userId);
        return "redirect:/homepage/" + userId;
    }

    //homepage/post/comment/comment-like(userId=${userId},postId=${tempComment.postId},commentId=${tempComment.id})
    @GetMapping("homepage/post/comment/comment-like")
    public String commentLike(@RequestParam("userId") String userId, @RequestParam("postId") String postId, @RequestParam("commentId") String id) {
        System.out.println("USER ID: " + userId);
        System.out.println("POST ID: " + postId);
        System.out.println("COMMENT ID: " + id);
        commentLikeService.updateCommentLike(Long.parseLong(id), Long.parseLong(postId), userId);
        return "redirect:/homepage/" + userId;
    }

    @PostMapping(value = "/homepage/post/update")
    public String updatePost(@RequestParam(value="userId",required=false) String userId,
                             @RequestParam(value="postId",required=false) String postId,
                             @RequestParam(value="post",required=false) String post
                             ) {
        System.out.println("USER ID " + userId);
        System.out.println("POST ID " + postId);
        System.out.println("POST MESSAGE " + post);

        postService.updatePost(userId, Long.parseLong(postId), post);
        return "redirect:/homepage/" + userId;
    }

    ///homepage/post/comment
    @PostMapping(value = "/homepage/post/comment")
    public String comment(@RequestParam(value="userId",required=false) String userId,
                             @RequestParam(value="postId",required=false) String postId,
                             @RequestParam(value="comment",required=false) String comment,
                             @RequestParam(value="username",required=false) String username
    ) {
        System.out.println("USER ID " + userId);
        System.out.println("POST ID " + postId);
        System.out.println("COMMENT " + comment);

        CommentDto commentDto = new CommentDto();
        commentDto.setMessage(comment);
        commentDto.setPostId(Long.parseLong(postId));
        commentDto.setUserId(userId);
        commentDto.setName(username);

        commentService.comment(commentDto, userId, Long.parseLong(postId));
        return "redirect:/homepage/" + userId;
    }

    ///homepage/post/comment/update
    @PostMapping(value = "/homepage/post/comment/update")
    public String commentUpdate(@RequestParam(value="userId",required=false) String userId,
                          @RequestParam(value="postId",required=false) String postId,
                          @RequestParam(value="comment",required=false) String comment,
                          @RequestParam(value="username",required=false) String username,
                          @RequestParam(value="commentId",required=false) String commentId
    ) {
        System.out.println("USER ID " + userId);
        System.out.println("POST ID " + postId);
        System.out.println("COMMENT " + comment);
        System.out.println("COMMENT ID " + commentId);

        CommentDto commentDto = new CommentDto();
        commentDto.setMessage(comment);
        commentDto.setPostId(Long.parseLong(postId));
        commentDto.setUserId(userId);
        commentDto.setName(username);
        commentDto.setId(Long.parseLong(commentId));

        commentService.updateComment(commentDto, userId, Long.parseLong(postId), Long.parseLong(commentId));
        return "redirect:/homepage/" + userId;
    }

    //homepage/post/delete
    @GetMapping("homepage/post/delete")
    public String postDelete(@RequestParam("userId") String userId, @RequestParam("postId") String postId) {
        System.out.println("USER ID: " + userId);
        System.out.println("POST ID: " + postId);
        postService.deletePost(Long.parseLong(postId), userId);
        return "redirect:/homepage/" + userId;
    }

    //homepage/post/comment/delete
    @GetMapping("homepage/post/comment/delete")
    public String commentDelete(@RequestParam("userId") String userId, @RequestParam("postId") String postId, @RequestParam("commentId") String id) {
        System.out.println("USER ID: " + userId);
        System.out.println("POST ID: " + postId);
        System.out.println("COMMENT ID: " + id);
        commentService.deleteComment(userId, Long.parseLong(postId), Long.parseLong(id));
        return "redirect:/homepage/" + userId;
    }



}


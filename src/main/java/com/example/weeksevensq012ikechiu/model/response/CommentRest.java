package com.example.weeksevensq012ikechiu.model.response;


import lombok.Data;
import java.util.List;

@Data
public class CommentRest {
    private Long id;
    private String message;
    private Long postId;
    private String userId;
    private String name;
    private List<CommentLikeRest> commentLikeRests;
}

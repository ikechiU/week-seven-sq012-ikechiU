package com.example.weeksevensq012ikechiu.model.response;

import com.example.weeksevensq012ikechiu.shared.dto.CommentDto;
import com.example.weeksevensq012ikechiu.shared.dto.PostLikeDto;
import lombok.Data;

import java.util.List;

@Data
public class PostRest {
    private Long id;
    private String userId;
    private String message;
    private String name;
    private List<PostLikeRest> postLikeRests;
    private List<CommentRest> commentRests;
}

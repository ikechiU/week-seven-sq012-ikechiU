package com.example.weeksevensq012ikechiu.model.response;

import com.example.weeksevensq012ikechiu.shared.dto.CommentDto;
import lombok.Data;

@Data
public class CommentLikeRest {
    private Long id;
    private boolean liked;
    private int postId;
    private String userId;
}

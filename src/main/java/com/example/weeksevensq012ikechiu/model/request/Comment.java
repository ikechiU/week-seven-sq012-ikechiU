package com.example.weeksevensq012ikechiu.model.request;

import com.example.weeksevensq012ikechiu.shared.dto.CommentLikeDto;
import com.example.weeksevensq012ikechiu.shared.dto.PostDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Comment {
    private String message;
    private long postId;
    private String userId;
    private String name;
}

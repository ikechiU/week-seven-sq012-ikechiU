package com.example.weeksevensq012ikechiu.shared.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostLikeDto {
    private Long id;
    private boolean liked;
    private Long postId;
    private String userId;
    private PostDto postDto;
}

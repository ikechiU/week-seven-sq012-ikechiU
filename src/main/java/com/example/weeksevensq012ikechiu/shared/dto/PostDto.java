package com.example.weeksevensq012ikechiu.shared.dto;


import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class PostDto {
    private Long id;
    private String userId;
    private String message;
    private String name;
    private UserDto userDto;
    private List<PostLikeDto> postLikeDtos;
    private List<CommentDto> commentDtos;
}

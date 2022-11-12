package com.example.weeksevensq012ikechiu.shared.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class UserDto {
    private Long id;
    private String userId;
    private String firstname;
    private String lastname;
    private String contact;
    private String password;
    private String dob;
    private String gender;
    private List<PostDto> postDtos;
}

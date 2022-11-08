package com.example.weeksevensq012ikechiu.shared.dto;

import com.example.weeksevensq012ikechiu.model.request.Post;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class UserDto implements Serializable {
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private static final long serialVersionUID = -7250245677359142038L;
    private Long id;
    private String userId;
    private String firstname;
    private String lastname;
    private String contact;
    private String password;
    private String dob;
    private String gender;
    private List<Post> posts;
}

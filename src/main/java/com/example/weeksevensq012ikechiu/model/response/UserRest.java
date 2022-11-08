package com.example.weeksevensq012ikechiu.model.response;

import com.example.weeksevensq012ikechiu.model.request.Post;
import lombok.Data;

import java.util.List;

@Data
public class UserRest {
    private String userId;
    private String firstname;
    private String lastname;
    private String contact;
    private String dob;
    private String gender;
    private List<Post> posts;
}

package com.example.weeksevensq012ikechiu.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    private String firstname;
    private String lastname;
    private String contact;
    private String password;
    private String dob;
    private String gender;
    private List<Post> posts;

    public User(String firstname, String lastname, String contact, String password, String dob, String gender) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.contact = contact;
        this.dob = dob;
        this.gender = gender;
    }
}

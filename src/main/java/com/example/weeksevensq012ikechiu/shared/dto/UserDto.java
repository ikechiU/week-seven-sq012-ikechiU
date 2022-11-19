package com.example.weeksevensq012ikechiu.shared.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@Setter
public class UserDto {
    private Long id;
    private String userId;
    @NotBlank(message = "Firstname is mandatory")
    private String firstname;
    @NotBlank(message = "Lastname is mandatory")
    private String lastname;
    @NotBlank(message = "Contact is mandatory")
    private String contact;
    @NotBlank(message = "Password is mandatory")
    private String password;
    @NotBlank(message = "Date is mandatory")
    private String dob;
    @NotBlank(message = "Gender is mandatory")
    private String gender;
    private List<PostDto> postDtos;
}

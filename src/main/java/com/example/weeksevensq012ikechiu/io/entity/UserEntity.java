package com.example.weeksevensq012ikechiu.io.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@Entity(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
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
    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
    private List<PostEntity> posts;
}

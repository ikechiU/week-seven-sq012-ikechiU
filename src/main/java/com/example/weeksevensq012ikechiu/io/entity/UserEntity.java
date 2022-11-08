package com.example.weeksevensq012ikechiu.io.entity;

import com.example.weeksevensq012ikechiu.model.request.Post;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity(name = "users")
public class UserEntity implements Serializable {
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private static final long serialVersionUID = 2485790437537414375L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(nullable = false)
    private String userId;
    @Column(nullable = false)
    private String firstname;
    @Column(nullable = false)
    private String lastname;
    @Column(nullable = false)
    private String contact;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String dob;
    @Column(nullable = false)
    private String gender;
    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
    private List<PostEntity> posts;
}

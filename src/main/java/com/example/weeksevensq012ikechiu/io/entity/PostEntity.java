package com.example.weeksevensq012ikechiu.io.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@Entity(name = "posts")
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "user_id")
    private String userId;
    private String message;
    private String name;
    @ManyToOne
    @JoinColumn(name = "users_user_id")
    private UserEntity users;
    @OneToMany(mappedBy = "posts", cascade = CascadeType.ALL)
    private List<PostLikeEntity> post_likes;
    @OneToMany(mappedBy = "posts", cascade = CascadeType.ALL)
    private List<CommentEntity> comments;
}

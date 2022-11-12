package com.example.weeksevensq012ikechiu.io.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@Entity(name = "comments")
public class CommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;
    private Long postId;
    private String userId;
    private String name;
    @ManyToOne
    @JoinColumn(name = "posts_id")
    private PostEntity posts;
    @OneToMany(mappedBy = "comments", cascade = CascadeType.ALL)
    private List<CommentLikeEntity> comment_likes;

}

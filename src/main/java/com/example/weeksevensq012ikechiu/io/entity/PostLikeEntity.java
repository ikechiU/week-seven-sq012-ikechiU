package com.example.weeksevensq012ikechiu.io.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity(name = "post_like")
public class PostLikeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean liked;
    private Long postId;
    private String userId;
    @ManyToOne
    @JoinColumn(name = "posts_id")
    private PostEntity posts;
}

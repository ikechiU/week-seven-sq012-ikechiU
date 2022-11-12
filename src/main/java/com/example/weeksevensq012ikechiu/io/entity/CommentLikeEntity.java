package com.example.weeksevensq012ikechiu.io.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "comment_like")
public class CommentLikeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean liked;
    private Long postId;
    private String userId;
    private Long commentId;
    @ManyToOne
    @JoinColumn(name = "comments_id")
    private CommentEntity comments;
}

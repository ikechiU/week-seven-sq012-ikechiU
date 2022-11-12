package com.example.weeksevensq012ikechiu.model.response;

import com.example.weeksevensq012ikechiu.io.entity.PostEntity;
import lombok.Data;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
public class PostLikeRest {
    private Long id;
    private boolean liked;
    private Long postId;
    private String userId;
}

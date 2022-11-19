package com.example.weeksevensq012ikechiu.io.repository;

import com.example.weeksevensq012ikechiu.io.entity.CommentLikeEntity;
import com.example.weeksevensq012ikechiu.io.entity.UserEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentLikeRepository extends PagingAndSortingRepository<CommentLikeEntity, Long> {
    Optional<CommentLikeEntity> findByCommentId(Long commentId);
    List<CommentLikeEntity> findAllByPostIdAndLiked(Long postId, boolean liked);
    List<CommentLikeEntity> findAllByCommentIdAndLiked(Long commentId, boolean liked);

    List<CommentLikeEntity> findAllByPostId(Long postId);

    CommentLikeEntity findByCommentIdAndPostIdAndUserId(Long commentId, Long postId, String userId);
}

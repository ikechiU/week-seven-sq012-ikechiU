package com.example.weeksevensq012ikechiu.io.repository;

import com.example.weeksevensq012ikechiu.io.entity.CommentEntity;
import com.example.weeksevensq012ikechiu.io.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends PagingAndSortingRepository<CommentEntity, Long> {
    Optional<CommentEntity> findByPostId(String userId);
    Page<CommentEntity> findAllByPostId(Long postId, Pageable pageable);
    List<CommentEntity> findAllByPostId(Long postId);
}

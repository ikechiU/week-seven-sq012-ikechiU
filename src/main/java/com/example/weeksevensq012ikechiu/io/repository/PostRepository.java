package com.example.weeksevensq012ikechiu.io.repository;

import com.example.weeksevensq012ikechiu.io.entity.PostEntity;
import com.example.weeksevensq012ikechiu.io.entity.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostRepository extends PagingAndSortingRepository<PostEntity, Long> {
    Optional<PostEntity> findPostEntitiesByUserId(String userId);
}

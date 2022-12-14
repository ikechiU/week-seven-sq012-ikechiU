package com.example.weeksevensq012ikechiu.io.repository;

import com.example.weeksevensq012ikechiu.io.entity.UserEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends PagingAndSortingRepository<UserEntity, Long> {
    Optional<UserEntity> findUserEntitiesByContact(String contact);
    Optional<UserEntity> findUserEntitiesByUserId(String userId);
}

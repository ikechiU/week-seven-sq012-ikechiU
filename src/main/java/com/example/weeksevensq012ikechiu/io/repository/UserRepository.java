package com.example.weeksevensq012ikechiu.io.repository;

import com.example.weeksevensq012ikechiu.io.entity.UserEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends PagingAndSortingRepository<UserEntity, Long> {
    UserEntity findUserEntitiesByContact(String contact);
    UserEntity findUserEntitiesByUserId(String userId);
}

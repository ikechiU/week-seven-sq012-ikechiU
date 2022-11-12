package com.example.weeksevensq012ikechiu.service;

import com.example.weeksevensq012ikechiu.io.entity.UserEntity;
import com.example.weeksevensq012ikechiu.model.response.ApiResponse;
import com.example.weeksevensq012ikechiu.model.response.OperationStatus;
import com.example.weeksevensq012ikechiu.model.response.UserRest;
import com.example.weeksevensq012ikechiu.shared.dto.UserDto;

import java.util.List;

public interface UserService {
    ApiResponse<UserRest> signUp(UserDto user);
    ApiResponse<UserRest> login(String contact, String password);
    UserEntity getUserByContact(String contact);
    UserEntity getUserById(String id);
    ApiResponse<UserRest> getUserByUserId(String userId);
    ApiResponse<UserRest> updateUser(String userId, UserDto user);
    ApiResponse<List<UserRest>> getUsers(int page, int limit);
    ApiResponse<OperationStatus> deleteUser(String userId);
}

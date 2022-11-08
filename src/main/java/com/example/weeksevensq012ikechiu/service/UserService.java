package com.example.weeksevensq012ikechiu.service;

import com.example.weeksevensq012ikechiu.model.request.User;
import com.example.weeksevensq012ikechiu.shared.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto signUp(UserDto user);
    UserDto login(String contact, String password);
    UserDto getUserByContact(String contact);
    UserDto getUserByUserId(String userId);
    UserDto updateUser(String userId, UserDto user);
    List<UserDto> getUsers(int page, int limit);
}

package com.example.weeksevensq012ikechiu.service.impl;

import com.example.weeksevensq012ikechiu.io.entity.UserEntity;
import com.example.weeksevensq012ikechiu.io.repository.UserRepository;
import com.example.weeksevensq012ikechiu.model.response.ApiResponse;
import com.example.weeksevensq012ikechiu.model.response.ResponseManager;
import com.example.weeksevensq012ikechiu.model.response.UserRest;
import com.example.weeksevensq012ikechiu.service.UserService;
import com.example.weeksevensq012ikechiu.shared.dto.UserDto;
import com.example.weeksevensq012ikechiu.shared.utils.Utils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;

class UserServiceImplTest {

    @Mock
    ResponseManager<UserRest> responseManager;
    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserServiceImpl userService;

    UserDto userDto;

    UserEntity user;

    ApiResponse<UserRest> apiResponse;

    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);
        userDto = new UserDto();
        userDto.setFirstname("James");
        userDto.setLastname("Michael");
        userDto.setGender("Male");
        userDto.setDob("20-10-1985");
        userDto.setContact("09123489321");
        userDto.setPassword("123456");

        user = new UserEntity();
        user.setId(1L);
        user.setUserId("45678910-987654324567");
        user.setFirstname("James");
        user.setLastname("Michael");
        user.setGender("Male");
        user.setDob("20-10-1985");
        user.setContact("09123489321");
        user.setPassword("123456");

        apiResponse = new ApiResponse<>(
                HttpStatus.CREATED.value(), HttpStatus.CREATED, "Success", true, new ModelMapper().map(userDto, UserRest.class)
        );
    }

    @Test
    void signUp() {
        Mockito.when(userRepository.findByContact(anyString())).thenReturn(Optional.empty());
        Mockito.when(userRepository.save(any(UserEntity.class))).thenReturn(user);
        Mockito.when(responseManager.success(eq(HttpStatus.CREATED), any(UserRest.class))).thenReturn(apiResponse);
        var result = userService.signUp(userDto);

        assertNotNull(result.getData());
    }

    @Test
    void login() {

    }

    @Test
    void getUserByContact() {

    }

    @Test
    void getUserById() {

    }

    @Test
    void getUserByUserId() {

    }

    @Test
    void updateUser() {

    }

    @Test
    void getUsers() {

    }

    @Test
    void deleteUser() {

    }
}
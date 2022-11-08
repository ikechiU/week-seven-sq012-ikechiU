package com.example.weeksevensq012ikechiu.service.impl;

import com.example.weeksevensq012ikechiu.exception.ErrorMessages;
import com.example.weeksevensq012ikechiu.exception.UserServiceException;
import com.example.weeksevensq012ikechiu.io.entity.UserEntity;
import com.example.weeksevensq012ikechiu.io.repository.UserRepository;
import com.example.weeksevensq012ikechiu.service.UserService;
import com.example.weeksevensq012ikechiu.shared.dto.UserDto;
import com.example.weeksevensq012ikechiu.shared.utils.Utils;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDto signUp(UserDto user) {
        if (user.getFirstname().isEmpty() || user.getLastname().isEmpty() || user.getContact().isEmpty() ||
                user.getPassword().isEmpty() || user.getDob().isEmpty() || user.getGender().isEmpty()) {
            throw new UserServiceException(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage());
        }

        if (userRepository.findUserEntitiesByContact(user.getContact()) != null)
            throw new UserServiceException(ErrorMessages.RECORD_ALREADY_EXIST.getErrorMessage());

        ModelMapper modelMapper = new ModelMapper();
        UserEntity userEntity = modelMapper.map(user, UserEntity.class);
        userEntity.setUserId(new Utils().generateUserId(8));

        UserEntity newUser = userRepository.save(userEntity);
        return modelMapper.map(newUser, UserDto.class);
    }

    @Override
    public UserDto login(String contact, String password) {
        UserEntity user = userRepository.findUserEntitiesByContact(contact);
        if (user == null) throw new UserServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());
        if (!user.getPassword().equals(password))
            throw new UserServiceException(ErrorMessages.INCORRECT_LOGIN_DETAILS.getErrorMessage());
        return new ModelMapper().map(user, UserDto.class);
    }

    @Override
    public UserDto getUserByContact(String contact) {
        return null;
    }

    @Override
    public UserDto getUserByUserId(String userId) {
        return null;
    }

    @Override
    public UserDto updateUser(String userId, UserDto user) {
        return null;
    }

    @Override
    public List<UserDto> getUsers(int page, int limit) {
        return null;
    }
}

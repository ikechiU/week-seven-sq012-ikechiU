package com.example.weeksevensq012ikechiu.service.impl;

import com.example.weeksevensq012ikechiu.exception.ErrorMessages;
import com.example.weeksevensq012ikechiu.io.entity.UserEntity;
import com.example.weeksevensq012ikechiu.io.repository.UserRepository;
import com.example.weeksevensq012ikechiu.model.response.*;
import com.example.weeksevensq012ikechiu.service.UserService;
import com.example.weeksevensq012ikechiu.shared.dto.UserDto;
import com.example.weeksevensq012ikechiu.shared.utils.Utils;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.internal.bytebuddy.description.method.MethodDescription;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.lang.reflect.Type;
import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ResponseManager<UserRest> responseManager;
    private final ModelMapper modelMapper;


    @Override
    public ApiResponse<UserRest> signUp(UserDto user) {
        if (user.getFirstname().isEmpty() || user.getLastname().isEmpty() || user.getContact().isEmpty() ||
                user.getPassword().isEmpty() || user.getDob().isEmpty() || user.getGender().isEmpty()) {
            return responseManager.error(HttpStatus.BAD_REQUEST, ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage());
        }

        if (userRepository.findUserEntitiesByContact(user.getContact()).isPresent())
            return responseManager.error(HttpStatus.CONFLICT, ErrorMessages.RECORD_ALREADY_EXIST.getErrorMessage());

        UserEntity userEntity = modelMapper.map(user, UserEntity.class);
        userEntity.setUserId(new Utils().generateUserId(8));

        UserEntity newUser = userRepository.save(userEntity);
        UserDto userDto = modelMapper.map(newUser, UserDto.class);
        UserRest userRest = modelMapper.map(userDto, UserRest.class);
        return responseManager.success(HttpStatus.CREATED, userRest);
    }

    @Override
    public ApiResponse<UserRest> login(String contact, String password) {
        UserEntity user = getUserByContact(contact);
        if (user == null) {
            return responseManager.error(HttpStatus.BAD_REQUEST, ErrorMessages.NO_RECORD_FOUND.getErrorMessage());
        }
        if (!user.getPassword().equals(password))
            return responseManager.error(HttpStatus.BAD_REQUEST, ErrorMessages.INCORRECT_LOGIN_DETAILS.getErrorMessage());

        UserDto userDto = modelMapper.map(user, UserDto.class);
        UserRest userRest = modelMapper.map(userDto, UserRest.class);
        return responseManager.success(HttpStatus.OK, userRest);
    }

    @Override
    public UserEntity getUserByContact(String contact) {
        return userRepository.findUserEntitiesByContact(contact).orElse(null);
    }

    @Override
    public UserEntity getUserById(String id) {
        return userRepository.findUserEntitiesByUserId(id).orElse(null);
    }

    @Override
    public ApiResponse<UserRest> getUserByUserId(String userId) {
        UserEntity user = getUserById(userId);
        if (user == null)
            return responseManager.error(HttpStatus.BAD_REQUEST, ErrorMessages.NO_RECORD_FOUND.getErrorMessage());

        UserDto userDto = modelMapper.map(user, UserDto.class);
        UserRest userRest = modelMapper.map(userDto, UserRest.class);
        return responseManager.success(HttpStatus.OK, userRest);
    }

    @Override
    public ApiResponse<UserRest> updateUser(String userId, UserDto user) {
        UserEntity userEntity = getUserById(userId);
        if (userEntity == null)
            return responseManager.error(HttpStatus.BAD_REQUEST, ErrorMessages.NO_RECORD_FOUND.getErrorMessage());

        UserEntity copyUpdate = modelMapper.map(user, UserEntity.class);
        copyUpdate.setId(userEntity.getId());
        copyUpdate.setUserId(userId);
        UserEntity updatedEntity = userRepository.save(copyUpdate);

        UserDto userDto = modelMapper.map(updatedEntity, UserDto.class);
        UserRest userRest = modelMapper.map(userDto, UserRest.class);
        return responseManager.success(HttpStatus.OK, userRest);
    }

    @Override
    public ApiResponse<List<UserRest>> getUsers(int page, int limit) {
        ResponseManager<List<UserRest>> manager = new ResponseManager<>();

        if (page > 0) page = page - 1;

        PageRequest pageable = PageRequest.of(page, limit, Sort.by("id").descending());
        Page<UserEntity> userEntities = userRepository.findAll(pageable);

        Type dtoType = new TypeToken<List<UserDto>>() {}.getType();
        List<UserDto> userDtoList = modelMapper.map(userEntities.getContent(), dtoType);

        Type resType = new TypeToken<List<UserRest>>() {}.getType();
        List<UserRest> userRests = modelMapper.map(userDtoList, resType);

        return manager.success(HttpStatus.OK, userRests);
    }

    @Override
    public ApiResponse<OperationStatus> deleteUser(String userId) {
        ResponseManager<OperationStatus> manager = new ResponseManager<>();

        UserEntity userEntity = getUserById(userId);
        if (userEntity == null)
            return manager.error(HttpStatus.BAD_REQUEST, ErrorMessages.NO_RECORD_FOUND.getErrorMessage());

        userRepository.delete(userEntity);
        return manager.success(HttpStatus.OK, new OperationStatus(OperationName.DELETE.name(), OperationResult.SUCCESS.name()));
    }
}

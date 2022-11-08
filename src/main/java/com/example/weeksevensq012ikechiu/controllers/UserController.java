package com.example.weeksevensq012ikechiu.controllers;

import com.example.weeksevensq012ikechiu.model.request.Login;
import com.example.weeksevensq012ikechiu.model.request.User;
import com.example.weeksevensq012ikechiu.model.response.UserRest;
import com.example.weeksevensq012ikechiu.service.impl.UserServiceImpl;
import com.example.weeksevensq012ikechiu.shared.dto.UserDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public UserRest signUp(@RequestBody User user) {
        ModelMapper modelMapper = new ModelMapper();
        UserDto userDto = modelMapper.map(user, UserDto.class);
        return modelMapper.map(userService.signUp(userDto), UserRest.class);
    }

    @PostMapping(path = "/login", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public UserRest login(@RequestBody Login login) {
        return new ModelMapper().map(userService.login(login.getContact(), login.getPassword()), UserRest.class);
    }

    @GetMapping(path = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public UserRest getUserByUserId(@PathVariable String id) {
        UserDto userDto = userService.getUserByUserId(id);
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(userDto, UserRest.class);
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<UserRest> getUsers(@RequestParam(value = "page", defaultValue = "0") int page,
                                   @RequestParam(value = "limit", defaultValue = "5") int limit) {
        List<UserDto> userDtoList = userService.getUsers(page, limit);
        Type listType = new TypeToken<List<UserRest>>() {}.getType();
        return new ModelMapper().map(userDtoList, listType);
    }
}

package ru.skillbox.webapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.skillbox.webapi.model.User.SearchDtoUser;
import ru.skillbox.webapi.model.User.User;
import ru.skillbox.webapi.model.User.CreateUserDto;
import ru.skillbox.webapi.service.ICrudService;
import ru.skillbox.webapi.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController extends AbstractCrudController<CreateUserDto, SearchDtoUser, User> {

    @Autowired
    private UserService userService;

    @Override
    protected ICrudService<CreateUserDto, SearchDtoUser, User> getCrudService() {
        return this.userService;
    }
    
}

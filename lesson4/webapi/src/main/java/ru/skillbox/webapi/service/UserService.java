package ru.skillbox.webapi.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import ru.skillbox.webapi.model.User.SearchDtoUser;
import ru.skillbox.webapi.model.User.User;
import ru.skillbox.webapi.model.User.CreateUserDto;
import ru.skillbox.webapi.repository.UserRepository;

@Service
public class UserService extends AbstractCrudService<CreateUserDto, SearchDtoUser, User> {

    private UserRepository userRepository;
    public ModelMapper modelMapper;
    
    public UserService(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public User mapToEntity(CreateUserDto s) {
        return modelMapper.map(s, User.class);
    }

    @Override
    public SearchDtoUser mapToSearch(User s) {
        return modelMapper.map(s, SearchDtoUser.class);
    }

    @Override
    protected UserRepository getRepository() {
        return this.userRepository;
    }
}

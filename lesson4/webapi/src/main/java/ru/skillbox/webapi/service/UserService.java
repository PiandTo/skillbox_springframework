package ru.skillbox.webapi.service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import ru.skillbox.webapi.model.User.SearchDtoUser;
import ru.skillbox.webapi.model.User.User;
import ru.skillbox.webapi.model.New.News;
import ru.skillbox.webapi.model.New.SearchDtoNews;
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
        SearchDtoUser a = modelMapper.map(s, SearchDtoUser.class);
        List<News> news = s.getNewsArraList();
        if (news != null) {
            System.out.println(news.get(0));
            Type target = new TypeToken<List<SearchDtoNews>>(){}.getType();
            ArrayList<SearchDtoNews> newsArray = modelMapper.map(news,target);
            System.out.println(newsArray);
            a.setNewsArray(newsArray);
        }
        return a;
    }

    @Override
    protected UserRepository getRepository() {
        return this.userRepository;
    }
}

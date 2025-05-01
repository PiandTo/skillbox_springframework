package ru.skillbox.webapi.service;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import ru.skillbox.webapi.model.New.News;
import ru.skillbox.webapi.model.New.CreateNewsDto;
import ru.skillbox.webapi.model.New.SearchDtoNews;
import ru.skillbox.webapi.model.User.User;
import ru.skillbox.webapi.repository.NewsRepository;
import ru.skillbox.webapi.repository.UserRepository;

@Service
public class NewsService extends AbstractCrudService<CreateNewsDto, SearchDtoNews, News> {

    private final NewsRepository newsRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public NewsService(NewsRepository newsRepository, ModelMapper modelMapper, UserRepository userRepository) {
        this.newsRepository = newsRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    protected JpaRepository<News, UUID> getRepository() {
        return this.newsRepository;
    }

    @Override
    public News mapToEntity(CreateNewsDto s) {
        return modelMapper.map(s, News.class);
    }

    @Override
    public SearchDtoNews mapToSearch(News s) {
        return modelMapper.map(s, SearchDtoNews.class);
    }
    
    public SearchDtoNews addNewsToUser(CreateNewsDto news, String id) {
        User user = userRepository.findById(UUID.fromString(id)).orElseThrow();
        News news1 = mapToEntity(news);
        user.addNews(news1);
        return mapToSearch(newsRepository.save(news1));
    }

}

package ru.skillbox.webapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.skillbox.webapi.model.New.News;
import ru.skillbox.webapi.model.New.CreateNewsDto;
import ru.skillbox.webapi.model.New.SearchDtoNews;
import ru.skillbox.webapi.service.ICrudService;
import ru.skillbox.webapi.service.NewsService;

@RestController
@RequestMapping("/news")
public class NewsController extends AbstractCrudController<CreateNewsDto, SearchDtoNews, News> {

    @Autowired
    private NewsService newsService;

    @Override
    protected ICrudService<CreateNewsDto, SearchDtoNews, News> getCrudService() {
        return this.newsService;
    }

    @PostMapping("/{id}")
    public SearchDtoNews addNewsToUser(@PathVariable String id, @RequestBody CreateNewsDto news) {
        return newsService.addNewsToUser(news, id);
    }
    
}

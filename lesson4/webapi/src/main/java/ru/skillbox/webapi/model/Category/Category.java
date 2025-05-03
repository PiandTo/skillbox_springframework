package ru.skillbox.webapi.model.Category;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.skillbox.webapi.model.BaseEntity;
import ru.skillbox.webapi.model.New.News;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "category_webapi")
public class Category extends BaseEntity {
    private String type;

    @OneToMany(mappedBy = "category")
    private List<News> lNews;

    public Category addNews(News news) {
        if (lNews == null) {
            lNews = new ArrayList<>();
        }
        lNews.add(news);
        news.setCategory(this);
        return this;
    }

    public Category removCategory(News news) {
        if (lNews == null) {
            return null;
        }
        lNews.remove(news);
        news.setCategory(null);
        return this;
    }
}

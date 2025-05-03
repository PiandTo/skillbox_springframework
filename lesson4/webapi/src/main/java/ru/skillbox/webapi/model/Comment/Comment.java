package ru.skillbox.webapi.model.Comment;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.skillbox.webapi.model.BaseEntity;
import ru.skillbox.webapi.model.New.News;
import ru.skillbox.webapi.model.User.User;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "comment_webapi")
public class Comment extends BaseEntity{
    private String text;

    @ManyToOne
    @JoinColumn (name = "author_id", nullable = false)
    private User author;

    @ManyToOne
    @JoinColumn(name = "news_id", nullable = false)
    private News news;
}

package ru.skillbox.webapi.model.New;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.skillbox.webapi.model.BaseEntity;
import ru.skillbox.webapi.model.Category.Category;
import ru.skillbox.webapi.model.Comment.Comment;
import ru.skillbox.webapi.model.User.User;

@Entity
@Table(name = "news_webapi")
@NoArgsConstructor
@Getter
@Setter
public class News extends BaseEntity {
    private String title;
    private String text;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "news")
    private List<Comment> lComments;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private Category category;

    public News addComments(Comment comment) {
        if(lComments == null) {
            lComments = new ArrayList<>();
        }
        lComments.add(comment);
        comment.setNews(this);
        return this;
    }

    public News removeComment(Comment comment) {
        if (lComments == null) {
            return null;
        }
        lComments.remove(comment);
        comment.setNews(null);
        return this;
    }
}

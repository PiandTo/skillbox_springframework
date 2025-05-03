package ru.skillbox.webapi.model.New;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.skillbox.webapi.model.BaseEntity;
import ru.skillbox.webapi.model.IModel;
import ru.skillbox.webapi.model.User.User;

@Entity
@Table(name = "news_webapi")
@NoArgsConstructor
@Getter
@Setter
public class News extends BaseEntity {
    private String title;
    private String text;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}

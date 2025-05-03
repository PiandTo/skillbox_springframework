package ru.skillbox.webapi.model.User;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.skillbox.webapi.model.BaseEntity;
import ru.skillbox.webapi.model.New.News;

@Entity
@Table(name = "user_webapi")
@NoArgsConstructor
@Getter
@Setter
public class User extends BaseEntity {
	private String name;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	// @JsonIgnoreProperties("user")
	private List<News> newsArraList;

	public User addNews(News news) {
		if (newsArraList == null) {
			newsArraList = new ArrayList<>();
		}
		newsArraList.add(news);
		news.setUser(this);
		return this;
	}

	public User removeNews(News news) {
		if (newsArraList == null) {
			newsArraList = new ArrayList<>();
		}
		newsArraList.remove(news);
		news.setUser(null);
		return this;
	}
}

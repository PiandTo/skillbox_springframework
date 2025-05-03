package ru.skillbox.webapi.model.User;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.skillbox.webapi.model.BaseEntity;
import ru.skillbox.webapi.model.Comment.Comment;
import ru.skillbox.webapi.model.New.News;

@Entity
@Table(name = "user_webapi")
@NoArgsConstructor
@Getter
@Setter
public class User extends BaseEntity {
	private String name;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<News> newsArraList;

	@OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
	private List<Comment> lComments;

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
			return null;
		}
		newsArraList.remove(news);
		news.setUser(null);
		return this;
	}

	public User addComments(Comment comment) {
		if (lComments == null) {
			lComments = new ArrayList<>();
		}
		lComments.add(comment);
		comment.setAuthor(this);
		return this;
	}

	public User removeComment(Comment comment) {
		if (lComments == null) {
			return null;
		}
		lComments.remove(comment);
		comment.setAuthor(null);
		return this;
	}
}
